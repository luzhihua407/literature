package com.aiyo407.literature.timeline.entity;

import com.aiyo407.literature.article.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 时间轴事件
 * </p>
 *
 * @author luzh
 * @since 2021-10-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("timeline_event")
public class TimelineEvent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 事件开始时间
     */
    private String start;

    /**
     * 时间结束时间
     */
    private String end;

    /**
     * 文本
     */
    private String text;

    /**
     * 进度
     */
    private String progress;

    /**
     * fuzzy
     */
    private Boolean fuzzy;

    /**
     * Fuzzy Start
     */
    private Boolean fuzzyStart;

    /**
     * Fuzzy End
     */
    private Boolean fuzzyEnd;

    /**
     * 锁定
     */
    private Boolean locked;

    /**
     * 今天结束
     */
    private Boolean endsToday;

    /**
     * 分类
     */
    private String category;

    /**
     * 描述
     */
    private String description;

    /**
     * 标签
     */
    private String labels;

    /**
     * 创建时间
     */
    private String defaultColor;


}
