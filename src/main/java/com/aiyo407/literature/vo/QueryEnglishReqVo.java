package com.aiyo407.literature.vo;

import lombok.Data;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName queryArticleReqVo.java
 * @Description TODO
 * @createTime 2021年11月24日 08:59:00
 */
@Data
public class QueryEnglishReqVo extends PageVo {

	private Integer category=1;
	private String word;
	private String chinese;

}
