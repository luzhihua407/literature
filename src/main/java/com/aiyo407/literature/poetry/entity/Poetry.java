package com.aiyo407.literature.poetry.entity;

import com.aiyo407.literature.entity.AbstractEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

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
@Document(indexName = "poetry")
public class Poetry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id = null;
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
    @Field
    private String author;

    /**
     * 朝代
     */
    private String dynasty;


}
