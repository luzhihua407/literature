package com.aiyo407.literature.entity;

import com.aiyo407.literature.enums.DynastyEnum;
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
 * @since 2020-02-21
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class Poetry implements Serializable {

    private static final long serialVersionUID = 1L;


    private String title;

    private String body;

    private String author;

    private DynastyEnum dynasty;



}
