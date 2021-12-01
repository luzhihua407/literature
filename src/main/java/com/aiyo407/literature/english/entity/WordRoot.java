package com.aiyo407.literature.english.entity;

import com.aiyo407.literature.article.entity.BaseEntity;
import com.aiyo407.literature.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author luzh
 * @since 2021-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WordRoot extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 单词
     */
    private String root;

    /**
     * 中文
     */
    private String chinese;


}
