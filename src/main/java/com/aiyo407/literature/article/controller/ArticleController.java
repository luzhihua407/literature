package com.aiyo407.literature.article.controller;


import com.aiyo407.literature.article.entity.Article;
import com.aiyo407.literature.enums.ArticleCategoryEnum;
import com.aiyo407.literature.util.EnumUtils;
import com.aiyo407.literature.util.PageInfo;
import com.aiyo407.literature.vo.QueryArticleReqVo;
import com.aiyo407.literature.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
import org.elasticsearch.search.aggregations.bucket.composite.ParsedComposite;
import org.elasticsearch.search.aggregations.bucket.composite.TermsValuesSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("article")
public class ArticleController {


    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


        @PostMapping(value ="/list",produces="application/json")
        public ResponseVo list(@RequestBody QueryArticleReqVo queryArticleReqVo) {
            String author = queryArticleReqVo.getAuthor();
            String keyword = queryArticleReqVo.getKeyword();
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.preTags("<b>");//设置前缀
            highlightBuilder.postTags("</b>");//设置后缀
            highlightBuilder.field("body");//设置高亮字段
            NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
            queryBuilder.withFields("id","title","author","body");
            //page start 0
            Pageable unpaged = PageRequest.of(queryArticleReqVo.getPageNumber(),15);
            NativeSearchQueryBuilder query = queryBuilder.withPageable(unpaged);
            String name = EnumUtils.getEnumName(ArticleCategoryEnum.class, queryArticleReqVo.getCategory());
            query.withFilter(QueryBuilders.matchQuery("category",name) );
            FieldSortBuilder sortBuilder = new FieldSortBuilder("id.keyword");
            sortBuilder.order(SortOrder.ASC);
            query.withSort(sortBuilder);
            if(StringUtils.isNotEmpty(author)){
                query.withQuery(QueryBuilders.matchQuery("author.keyword", author));
            }
            if(StringUtils.isNotEmpty(keyword)){

                query.withQuery(QueryBuilders.matchQuery("body", keyword));
            }
            query.withHighlightBuilder(highlightBuilder);
            AggregatedPage<Article> page = getArticles(queryBuilder.build());
            PageInfo<Object, Object> pageInfo = PageInfo.builder().from(page);
            return ResponseVo.success(pageInfo);
        }

    private AggregatedPage<Article> getArticles(SearchQuery searchQuery) {
        return (AggregatedPage<Article>) elasticsearchOperations.queryForPage(searchQuery, Article.class, new SearchResultMapper(){
                @Override
                public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                    long totalHits = searchResponse.getHits().getTotalHits();
                    float maxScore = searchResponse.getHits().getMaxScore();
                    SearchHits hits = searchResponse.getHits();
                    List<Article> results = new ArrayList<>();
                    Iterator<SearchHit> iterator = hits.iterator();
                    while (iterator.hasNext()) {
                        SearchHit next = iterator.next();
                        Article article = new Article();
                        Map<String, Object> sourceAsMap = next.getSourceAsMap();
                        Map<String, HighlightField> highlightFields = next.getHighlightFields();
                        article.setAuthor((String) sourceAsMap.get("author"));
                        article.setTitle((String) sourceAsMap.get("title"));
                        article.setBody((String) sourceAsMap.get("body"));
                        if (sourceAsMap.containsKey("id")) {

                            article.setId(Long.valueOf((String) sourceAsMap.get("id")));
                        }
                        HighlightField body = highlightFields.get("body");
                        if (body != null) {

                            Text[] fragments = body.getFragments();
                            Text fragment = fragments[0];
                            String name = fragment.string();
                            article.setBody(name);
                            System.err.println(name);
                        }
                        results.add(article);
                    }
                    return new AggregatedPageImpl(results, pageable, totalHits, searchResponse.getAggregations(), searchResponse.getScrollId(), maxScore);
                }

                @Override
                public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                    return null;
                }
            });
    }

    private Page<Article> firstLetterGroup() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        List<CompositeValuesSourceBuilder<?>> sources=new ArrayList<>();
        sources.add(new TermsValuesSourceBuilder("firstLetter").field("firstLetter.keyword"));
        CompositeAggregationBuilder author = AggregationBuilders.composite("firstLetterAgg", sources).size(200);
        QueryBuilder queryBuilder2=QueryBuilders.matchPhraseQuery("category", ArticleCategoryEnum.诗词.name());
        queryBuilder.withQuery(queryBuilder2);
        queryBuilder.addAggregation(author);
        return elasticsearchOperations.queryForPage(queryBuilder.build(), Article.class, new SearchResultMapper() {


                    @Override
                    public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                        long totalHits = searchResponse.getHits().getTotalHits();
                        float maxScore = searchResponse.getHits().getMaxScore();
                        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                        Aggregations aggregations = searchResponse.getAggregations();
                        ParsedComposite parsedComposite = aggregations.get("firstLetterAgg");
                        List<ParsedComposite.ParsedBucket> buckets = parsedComposite.getBuckets();
                        for (int i = 0; i < buckets.size(); i++) {
                            ParsedComposite.ParsedBucket bucket = buckets.get(i);
                            Map<String, Object> map = bucket.getKey();
                            Object firstLetter = map.get("firstLetter");
                            NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
                            QueryBuilder queryBuilder1=QueryBuilders.matchPhraseQuery("firstLetter", firstLetter);
                            QueryBuilder queryBuilder2=QueryBuilders.matchPhraseQuery("category", ArticleCategoryEnum.诗词.name());
                            QueryBuilder multiQueryBuilder=QueryBuilders.boolQuery().must(queryBuilder1).must(queryBuilder2);
                            Pageable unpaged = PageRequest.of(0,100);
                            queryBuilder.withPageable(unpaged);
                            queryBuilder.withFilter(multiQueryBuilder);
                            queryBuilder.withFields("author");
                            queryBuilder.withCollapseField("author.keyword");
                            List<Article> articles = elasticsearchOperations.queryForList(queryBuilder.build(), Article.class);
                            List<String> authors=new ArrayList<>();
                            if(!articles.isEmpty()){
                                for (int j = 0; j < articles.size(); j++) {
                                    Article article =  articles.get(j);
                                    String author1 = article.getAuthor();
                                    authors.add(author1);
                                }
                            }
                            map.put("authors",authors);
                            long docCount = bucket.getDocCount();
                            map.put("count", docCount);
                            list.add(map);
                        }
                        return new AggregatedPageImpl(list, pageable, totalHits, searchResponse.getAggregations(), searchResponse.getScrollId(), maxScore);

                    }

                    @Override
                    public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                        return null;
                    }
        });
    }

    @GetMapping("/getAuthorList")
    public ResponseVo getAuthorList() {
        Page<Article> authorAgg = firstLetterGroup();
        return ResponseVo.success(authorAgg);
    }



}
