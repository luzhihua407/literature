package com.aiyo407.literature.controller;


import com.aiyo407.literature.article.entity.Article;
import com.aiyo407.literature.article.service.IArticleService;
import com.aiyo407.literature.enums.ArticleCategoryEnum;
import com.aiyo407.literature.enums.DynastyEnum;
import org.apache.commons.io.FileUtils;
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
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luzh
 * @since 2020-02-21
 */
@RestController
@RequestMapping("")
public class IndexController {


    @Autowired
    private IArticleService articleService;
    @GetMapping("test")
    public String index() throws IOException {
        List<Map> list=new ArrayList<>();
        StringBuffer body=new StringBuffer();
            Map<String,String> map=new HashMap<>();
        List<String> lines = FileUtils.readLines(new File("C:\\Users\\86137\\Desktop\\laozi.txt"), "UTF-8");
        for (int i = 0; i < lines.size(); i++) {
            String s =  lines.get(i);
            if(StringUtils.isNotEmpty(s)){
                if(s.startsWith("第")){
                    if(body.length()>0){
                        map.put("body",body.toString());
                        list.add(map);
                        map=new HashMap<>();
                        body=new StringBuffer();
                    }
                    map.put("title",s);
//                    System.err.println(s);
                }else{
                    body.append(s);
                }
                System.err.println(i+"==="+s);
                if(i==600){
                    map.put("body",body.toString());
                    list.add(map);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Map map1 = list.get(i);
            Object title = map1.get("title");
            Object body1 = map1.get("body");
            System.err.println("title="+title);
            System.err.println("body="+body1);
            Article article=new Article();
            article.setBody(body1.toString());
            article.setTitle(title.toString());
            article.setAuthor("老子");
            article.setCategory(ArticleCategoryEnum.道德经);
            article.setDynasty(DynastyEnum.春秋);
            articleService.save(article);
        }

        return "ok";
    }



}
