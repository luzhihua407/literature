package com.aiyo407.literature.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName ResponseVo.java
 * @Description TODO
 * @createTime 2021年11月23日 16:52:00
 */
@Data
public class ResponseVo<T> implements Serializable {

	private Integer code;

	private List data;

	private ResponseVo(Integer code,List data){
		this.code=code;
		this.data=data;
	}

	public static ResponseVo success(List data){
		return new ResponseVo(200,data);
	}

	public static ResponseVo fail(Integer code){
		return new ResponseVo(code,null);
	}
}
