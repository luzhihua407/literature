package com.aiyo407.literature.controller;


import com.aiyo407.literature.poetry.entity.Poetry;
import com.aiyo407.literature.poetry.service.IPoetryService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.DefaultResultMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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
 * @since 2020-02-21
 */
@Controller
@RequestMapping()
public class IndexController {

    @Autowired
    private IPoetryService poetryService;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @RequestMapping("/query")
    public ModelAndView query(@RequestParam(defaultValue = "")String author,@RequestParam(defaultValue = "")String keyword,@RequestParam(defaultValue = "1") int pageNumber) throws IOException {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<b>");//设置前缀
        highlightBuilder.postTags("</b>");//设置后缀
        highlightBuilder.field("body");//设置高亮字段
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withFields("id","title","author","body");
        //page start 0
        Pageable unpaged = PageRequest.of(pageNumber-1,15);
        NativeSearchQueryBuilder query = queryBuilder.withPageable(unpaged);
        if(StringUtils.isNotEmpty(author)){
            query.withQuery(QueryBuilders.matchQuery("author", author));
        }
        if(StringUtils.isNotEmpty(keyword)){

        query.withQuery(QueryBuilders.matchQuery("body", keyword));
        }
        query.withHighlightBuilder(highlightBuilder);
        Page<Poetry> page = elasticsearchOperations.queryForPage(queryBuilder.build(), Poetry.class, new SearchResultMapper(){


            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                long totalHits = searchResponse.getHits().getTotalHits();
                float maxScore = searchResponse.getHits().getMaxScore();
                SearchHits hits = searchResponse.getHits();
                List<Poetry> results = new ArrayList<>();
                Iterator<SearchHit> iterator = hits.iterator();
                while (iterator.hasNext()) {
                    SearchHit next = iterator.next();
                    Poetry poetry = new Poetry();
                    Map<String, Object> sourceAsMap = next.getSourceAsMap();
                    Map<String, HighlightField> highlightFields = next.getHighlightFields();
                    poetry.setAuthor((String) sourceAsMap.get("author"));
                    poetry.setTitle((String) sourceAsMap.get("title"));
                    poetry.setBody((String) sourceAsMap.get("body"));
                    if (sourceAsMap.containsKey("id")) {

                        poetry.setId(Long.valueOf((String) sourceAsMap.get("id")));
                    }
                    HighlightField body = highlightFields.get("body");
                    if (body != null) {

                        Text[] fragments = body.getFragments();
                        Text fragment = fragments[0];
                        String name = fragment.string();
                        poetry.setBody(name);
                        System.err.println(name);
                    }
                    results.add(poetry);
                }
                return new AggregatedPageImpl(results, pageable, totalHits, searchResponse.getAggregations(), searchResponse.getScrollId(), maxScore);
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                return null;
            }
        });
        ModelAndView view=new ModelAndView("index");
        view.addObject("page",page);view.addObject("author",author);
        view.addObject("keyword",keyword);
        return view;
    }



}
