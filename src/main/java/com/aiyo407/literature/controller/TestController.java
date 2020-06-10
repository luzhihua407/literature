package com.aiyo407.literature.controller;


import com.aiyo407.literature.poetry.entity.Poetry;
import com.aiyo407.literature.poetry.service.IPoetryService;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
public class TestController {

    @Autowired
    private IPoetryService poetryService;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @GetMapping("index")
    public String index() throws IOException {
        List<Poetry> list = poetryService.list();
        for (int i = 0; i < list.size(); i++) {
            Poetry poetry =  list.get(i);
            Long id = poetry.getId();
            IndexQuery indexQuery = new IndexQueryBuilder()
                    .withId(poetry.getId().toString())
                    .withObject(poetry)
                    .build();
            String documentId = elasticsearchOperations.index(indexQuery);
            System.err.println(documentId);
        }
        return "ok";
    }


    @GetMapping("/deleteIndex")
    public String deleteIndex() {
        elasticsearchOperations.deleteIndex("*");
        return "ok";
    }
    @GetMapping("/poetry/{id}")
    public Poetry homePage(@PathVariable("id")  Long id) throws IOException {
        Poetry person = elasticsearchOperations
                .queryForObject(GetQuery.getById(id.toString()), Poetry.class);
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
