package com.aiyo407.literature.article.entity;

import com.aiyo407.literature.enums.ArticleCategoryEnum;
import com.aiyo407.literature.enums.DynastyEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author luzh
 * @since 2020-06-04
 */
@Data
@Accessors(chain = true)
@Document(indexName = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 标题
     */
    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String title;

    /**
     * 主体
     */
    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String body;

    /**
     * 作者
     */
    @Field(name = "author")
    private String author;

    /**
     * 姓名首字母
     */
    @Field(name = "firstLetter")
    private String firstLetter;

    /**
     * 朝代
     */
    private DynastyEnum dynasty;

    /**
     * 分类
     */
    private ArticleCategoryEnum category;
}
