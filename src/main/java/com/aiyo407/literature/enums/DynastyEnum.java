package com.aiyo407.literature.enums;

/**
 * 朝代枚举
 * @author luzh
 * @version 1.0.0
 * @ClassName DynastyEnum.java
 * @Description TODO
 * @createTime 2020年06月04日 10:21:00
 */
public enum DynastyEnum {

    唐朝(1),宋朝(2),元朝(3);


    private int value;
    DynastyEnum(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
