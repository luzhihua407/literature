package com.aiyo407.literature.english.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class English implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单词
     */
    private String word;

    /**
     * 发音
     */
    private String pronunciation;

    /**
     * 词性
     */
    private String partOfSpeech;

    /**
     * 中文
     */
    private String chinese;


}
