package com.aiyo407.literature.article.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName MapController.java
 * @Description TODO
 * @createTime 2021年04月01日 14:26:00
 */
@Controller
public class MapController {

	@RequestMapping(method = RequestMethod.GET,value = "display")
	public ModelAndView display() throws IOException {
		List<String> points = FileUtils.readLines(new File("C:\\Users\\86137\\Desktop\\11.txt"), "UTF-8");
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < points.size(); i++) {
			String s =  points.get(i);
			sb.append(s).append(" ");
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("points",sb);
		return modelAndView;
	}
}
