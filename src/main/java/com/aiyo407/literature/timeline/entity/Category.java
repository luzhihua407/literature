package com.aiyo407.literature.timeline.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.aiyo407.literature.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 时间轴分类
 * </p>
 *
 * @author luzh
 * @since 2021-10-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("timeline_category")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 颜色
     */
    private String color;

    /**
     * 进度颜色
     */
    private String progressColor;

    /**
     * 完成颜色
     */
    private String doneColor;

    /**
     * 字体颜色
     */
    private String fontColor;


}
