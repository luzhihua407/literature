package com.aiyo407.literature.controller;


import com.aiyo407.literature.enums.ArticleCategoryEnum;
import com.aiyo407.literature.vo.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luzh
 * @since 2020-02-21
 */
@RestController
@RequestMapping("menu")
public class MenuController {


    @GetMapping(value ="/list",produces="application/json")
    public ResponseVo index(){
        List<Map<String,Object>> navList=new ArrayList<Map<String,Object>>();
        ArticleCategoryEnum[] categoryEnums = ArticleCategoryEnum.values();
        for (int i = 0; i < categoryEnums.length; i++) {
            Map<String,Object> map=new HashMap<>();
            ArticleCategoryEnum categoryEnum = categoryEnums[i];
            String name = categoryEnum.name();
            int value = categoryEnum.getValue();
            map.put("name",name);
            map.put("value",value);
            navList.add(map);
        }
        return ResponseVo.success(navList);
    }



}
