package com.aiyo407.literature;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class KtuSpringBootCloudDemoApplicationTests {

    @Test
    void contextLoads() throws IOException {

        List<String> list = FileUtils.readLines(new File("C:\\Users\\86137\\Downloads\\zmj-7573-92468\\《宋词三百首》.txt"), "gbk");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).trim();
            char[] chars = s.toCharArray();
            boolean chinese=false;
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                chinese = isContainChinese(aChar);
                if(chinese){
                    break;
                }
            }
                if(chinese==false){

                    if(!StringUtils.isAllBlank(s)){

                        System.err.println("plain="+s);
                        if(s.contains(" ")){
                            String[] s1 = s.split("　");
                           String title=s1[0];
                           String author=s1[1];

                            System.err.println("title="+title);
                            System.err.println("author="+author);
                        }

                    }
                }else {
                    if(!StringUtils.isAllBlank(s)){
                        String s1 = StringUtils.replaceChars(s, " ", "");
                        s1= s1.replaceAll("　　","");
                        System.err.println("body="+s1);
                    }
                }
        }
    }


    /**
     * 判断字符是否是中文，能校验是否为中文标点符号
     *
     * @param str 待校验字符
     * @return 是否为中文
     */
    public static boolean isContainChinese(char str) {
        // 中文标点符号
        Pattern p = Pattern.compile("[\uFF01]|[\uFF0C-\uFF0E]|[\uFF1A-\uFF1B]|[\uFF1F]|[\uFF08-\uFF09]|[\u3001-\u3002]|[\u3010-\u3011]|[\u201C-\u201D]|[\u2013-\u2014]|[\u2018-\u2019]|[\u2026]|[\u3008-\u300F]|[\u3014-\u3015]");
        Matcher m = p.matcher(String.valueOf(str));
        return m.find();
    }
}
