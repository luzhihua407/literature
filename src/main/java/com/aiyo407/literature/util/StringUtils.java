package com.aiyo407.literature.util;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName StringUtils.java
 * @Description TODO
 * @createTime 2020年12月01日 17:06:00
 */
@Slf4j
public class StringUtils {

    /**
     * 中文转拼音
     * @param chinese
     * @return
     */
    public final static String toPinYin(String chinese){
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        char[] chars = chinese.toCharArray();
        StringBuffer pinyin=new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char  aChar= chars[i];
            String[] strings = new String[0];
            try {
                strings = PinyinHelper.toHanyuPinyinStringArray(aChar, hanyuPinyinOutputFormat);
                for (int j = 0; j < strings.length; j++) {
                    String string = strings[j];
                    pinyin.append(string);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                log.error(e.getMessage(),e);

            }
        }
        return  pinyin.toString();
    }

    public final  static String getFirstLetter(String pinyin){
        String letter=null;
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(pinyin)){
            letter =pinyin.substring(0,1);
        }
        return letter;
    }


    public final static String toURLParams(Map<String, String[]> model){

        StringBuffer params=new StringBuffer();
        Set<String> keySet = model.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key =  iterator.next();
            String[] o = model.get(key);
            String value = Arrays.toString(o).replace("[", "").replace("]", "");
            if(value.equals("") || key.equals("pageNumber") || key.equals("pageSize") ){
                continue;
            }
            params.append(key).append("=").append(value).append("&");
        }
        if(params.length()>0){

            params.deleteCharAt(params.length()-1);
        }
        return params.toString();

    }
}
