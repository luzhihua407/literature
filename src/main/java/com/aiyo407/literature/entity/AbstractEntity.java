package com.aiyo407.literature.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author luzh
 * @since 2020-02-17
 */
@Data
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id = null;

    private String createBy;

    private Date createTime=new Date();

    private String lastUpdateBy;

    private Date lastUpdateTime=new Date();

    private Double orderno;

    private Boolean valid=true;

    private Integer version=0;

    private Long createUser;

    private Long lastUpdateUser;



}
