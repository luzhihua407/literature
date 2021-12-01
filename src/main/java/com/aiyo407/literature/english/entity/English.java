package com.aiyo407.literature.english.entity;

import com.aiyo407.literature.article.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author luzh
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@Document(indexName = "english",createIndex = false,type = "_doc")
public class English  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 单词
     */
    @Field(analyzer = "my_analyzer")
    private String word;

    /**
     * 发音
     */
    @Field(name = "pronunciation")
    private String pronunciation;

    /**
     * 词性
     */
    @Field(name = "partOfSpeech")
    private String partOfSpeech;

    /**
     * 中文
     */
    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String chinese;


}
