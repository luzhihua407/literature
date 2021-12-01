package com.aiyo407.literature.english.controller;


import com.aiyo407.literature.english.entity.English;
import com.aiyo407.literature.enums.ArticleCategoryEnum;
import com.aiyo407.literature.util.EnumUtils;
import com.aiyo407.literature.util.PageInfo;
import com.aiyo407.literature.vo.QueryEnglishReqVo;
import com.aiyo407.literature.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luzh
 * @since 2021-03-28
 */
@RestController
@RequestMapping("/english")
public class EnglishController {


	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	@PostMapping(value ="/list",produces="application/json")
	public ResponseVo list(@RequestBody QueryEnglishReqVo queryEnglishReqVo) {
		String chinese = queryEnglishReqVo.getChinese();
		String word = queryEnglishReqVo.getWord();
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.preTags("<b>");//设置前缀
		highlightBuilder.postTags("</b>");//设置后缀
		highlightBuilder.field("word");//设置高亮字段
		NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
		queryBuilder.withFields("id","word","pronunciation","partOfSpeech","chinese");
		//page start 0
		Pageable unpaged = PageRequest.of(queryEnglishReqVo.getPageNumber(),15);
		NativeSearchQueryBuilder query = queryBuilder.withPageable(unpaged);
		FieldSortBuilder sortBuilder = new FieldSortBuilder("id.keyword");
		sortBuilder.order(SortOrder.ASC);
		query.withSort(sortBuilder);
		if(StringUtils.isNotEmpty(word)){
			query.withQuery(QueryBuilders.matchQuery("word", word));
		}
		if(StringUtils.isNotEmpty(chinese)){

			query.withQuery(QueryBuilders.matchQuery("chinese", chinese));
		}
		query.withHighlightBuilder(highlightBuilder);
		AggregatedPage<English> page = getEnglishs(queryBuilder.build());
		PageInfo<Object, Object> pageInfo = PageInfo.builder().from(page);
		return ResponseVo.success(pageInfo);
	}

	private AggregatedPage<English> getEnglishs(SearchQuery searchQuery) {
		return (AggregatedPage<English>) elasticsearchOperations.queryForPage(searchQuery, English.class, new SearchResultMapper(){
			@Override
			public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
				long totalHits = searchResponse.getHits().getTotalHits();
				float maxScore = searchResponse.getHits().getMaxScore();
				SearchHits hits = searchResponse.getHits();
				List<English> results = new ArrayList<>();
				Iterator<SearchHit> iterator = hits.iterator();
				while (iterator.hasNext()) {
					SearchHit next = iterator.next();
					English english = new English();
					Map<String, Object> sourceAsMap = next.getSourceAsMap();
					Map<String, HighlightField> highlightFields = next.getHighlightFields();
					english.setChinese((String) sourceAsMap.get("chinese"));
					english.setPartOfSpeech((String) sourceAsMap.get("partOfSpeech"));
					english.setPronunciation((String) sourceAsMap.get("pronunciation"));
					if (sourceAsMap.containsKey("id")) {

						english.setId(Long.valueOf((String) sourceAsMap.get("id")));
					}
					HighlightField body = highlightFields.get("word");
					if (body != null) {

						Text[] fragments = body.getFragments();
						Text fragment = fragments[0];
						String name = fragment.string();
						english.setWord(name);
						System.err.println(name);
					}
					results.add(english);
				}
				return new AggregatedPageImpl(results, pageable, totalHits, searchResponse.getAggregations(), searchResponse.getScrollId(), maxScore);
			}

			@Override
			public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
				return null;
			}
		});
	}

}
