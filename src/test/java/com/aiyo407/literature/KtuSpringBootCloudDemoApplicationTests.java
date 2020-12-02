package com.aiyo407.literature;

import com.aiyo407.literature.article.entity.Article;
import com.aiyo407.literature.article.mapper.ArticleMapper;
import com.aiyo407.literature.article.service.IArticleService;
import com.aiyo407.literature.article.service.impl.ArticleServiceImpl;
import com.aiyo407.literature.enums.ArticleCategoryEnum;
import com.aiyo407.literature.enums.DynastyEnum;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class KtuSpringBootCloudDemoApplicationTests {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    IArticleService articleService;

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String word="赵佶";
        String pinYin = com.aiyo407.literature.util.StringUtils.toPinYin(word);
        String s = com.aiyo407.literature.util.StringUtils.getFirstLetter(pinYin);
        System.err.println(s);
    }
    @Test
    void run() throws IOException {

        List<Article> list = articleService.list();
        for (int i = 0; i < list.size(); i++) {
            Article article =  list.get(i);
            String author = article.getAuthor();
            String pinYin = com.aiyo407.literature.util.StringUtils.toPinYin(author);
            String s = com.aiyo407.literature.util.StringUtils.getFirstLetter(pinYin);
            System.err.println(String.format("%s,%s",pinYin,s));
            article.setFirstLetter(s);
            articleService.updateById(article);
        }

    }

    @Test
    void contextLoads() throws IOException {

        List<String> list = FileUtils.readLines(new File("C:\\Users\\86137\\Downloads\\论语.txt"), "gbk");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).trim();
            if(StringUtils.isNotEmpty(s)){
                char[] chars = s.toCharArray();
                boolean chinese=false;
                List<Character> rs=new ArrayList<>();
//                for (int j = 0; j < chars.length; j++) {
//                    char aChar = chars[j];
//                    System.err.println(aChar);
//                    boolean had=false;
//                    String str="99lib";
//                    char[] array = str.toCharArray();
//                    for (int k = 0; k < array.length; k++) {
//                        char c = array[k];
//                        if(c==aChar){
//                            had=true;
//                            break;
//                        }
//                    }
//                    if(had==false){
//                        rs.add(aChar);
//                    }
//                }
//                s= StringUtils.join(rs.toArray(new Character[]{}),"")+"\n";
                System.err.println(s);
                Article article = new Article();
                article.setAuthor("孔子");
                article.setBody(s);
                article.setDynasty(DynastyEnum.春秋);
                article.setTitle("论语");
                article.setCategory(ArticleCategoryEnum.论语);
                articleMapper.insert(article);
//                FileUtils.writeByteArrayToFile(new File("C:\\Users\\86137\\Downloads\\论语1.txt"),s.getBytes(),true);
            }
//            char[] chars = s.toCharArray();
//            boolean chinese=false;
//            for (int j = 0; j < chars.length; j++) {
//                char aChar = chars[j];
//                chinese = isContainChinese(aChar);
//                if(chinese){
//                    break;
//                }
//            }
//                if(chinese){
//                    if(!StringUtils.isAllBlank(s)){
//                        String s1 = StringUtils.replaceChars(s, " ", "");
//                        s1= s1.replaceAll("　　","");
//                        System.err.println("body="+s1);
//                    }
//                }
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
