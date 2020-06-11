package com.aiyo407.literature.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;


public class EnumUtils {

    /**
     * 获取枚举名称
     * @param enumClass 枚举类
     * @param value 枚举值
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> String getEnumName(Class<E> enumClass,int value) {
        Enum[] var2 = (Enum[]) enumClass.getEnumConstants();
        Field valueField = null;
        try {
            valueField = enumClass.getDeclaredField("value");
            ReflectionUtils.makeAccessible(valueField);
            int var3 = var2.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                E e = (E) var2[var4];
                int fVal = (Integer) ReflectionUtils.getField(valueField, e);
                if (value == fVal) {
                    return e.name();
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

}