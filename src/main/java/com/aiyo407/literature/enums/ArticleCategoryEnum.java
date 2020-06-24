package com.aiyo407.literature.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 文章分类枚举
 * @author luzh
 * @version 1.0.0
 * @ClassName DynastyEnum.java
 * @Description TODO
 * @createTime 2020年06月04日 10:21:00
 */
@Getter
public enum ArticleCategoryEnum {

    诗词(1),道德经(2),菜根谭(3);


    @EnumValue
    private int value;

    ArticleCategoryEnum(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
