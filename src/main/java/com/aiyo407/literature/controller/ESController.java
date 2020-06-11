package com.aiyo407.literature.controller;


import com.aiyo407.literature.article.entity.Article;
import com.aiyo407.literature.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luzh
 * @since 2020-02-21
 */
@RestController
@RequestMapping()
public class ESController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    /**
     * 创建ES索引
     * @return
     * @throws IOException
     */
    @GetMapping("index")
    public String index() throws IOException {
        List<Article> list = articleService.list();
        for (int i = 0; i < list.size(); i++) {
            Article article =  list.get(i);
            IndexQuery indexQuery = new IndexQueryBuilder()
                    .withId(article.getId().toString())
                    .withObject(article)
                    .build();
            String documentId = elasticsearchOperations.index(indexQuery);
            System.err.println(documentId);
        }
        return "ok";
    }


    /**
     * 删除ES索引
     * @return
     */
    @GetMapping("/deleteIndex")
    public String deleteIndex() {
        elasticsearchOperations.deleteIndex("*");
        return "ok";
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable("id")  Long id) throws IOException {
        Article person = elasticsearchOperations
                .queryForObject(GetQuery.getById(id.toString()), Article.class);
        return person;
    }


    /**
     * 判断字符是否是中文，能校验是否为中文标点符号
     *
     * @param str 待校验字符
     * @return 是否为中文
     */
    public static boolean isContainChinese(char str) {
        // 中文标点符号
        Pattern p = Pattern.compile("[\uFF01]|[\uFF0C-\uFF0E]|[\uFF1A-\uFF1B]|[\uFF1F]|[\uFF08-\uFF09]|[\u3001-\u3002]|[\u3010-\u3011]|[\u201C-\u201D]|[\u2013-\u2014]|[\u2018-\u2019]|[\u2026]|[\u3008-\u300F]|[\u3014-\u3015]");
        Matcher m = p.matcher(String.valueOf(str));
        return m.find();
    }

}
