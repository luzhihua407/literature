package com.aiyo407.literature.english.controller;


import com.aiyo407.literature.english.entity.WordRoot;
import com.aiyo407.literature.english.service.IWordRootService;
import com.aiyo407.literature.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luzh
 * @since 2021-11-27
 */
@RestController
@RequestMapping("/wordRoot")
public class WordRootController {

    @Autowired
    private IWordRootService wordRootService;

    @GetMapping(value ="/list",produces="application/json")
    public ResponseVo list() {
        List<WordRoot> list = wordRootService.list();
        return ResponseVo.success(list);
    }

}
