package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2021年10月19日 10:26:00
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category
{
	private String name;

	private String color;

	private String progress_color;

	private String done_color;

	private String font_color;

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return this.color;
	}
	public void setProgress_color(String progress_color){
		this.progress_color = progress_color;
	}
	public String getProgress_color(){
		return this.progress_color;
	}
	public void setDone_color(String done_color){
		this.done_color = done_color;
	}
	public String getDone_color(){
		return this.done_color;
	}
	public void setFont_color(String font_color){
		this.font_color = font_color;
	}
	public String getFont_color(){
		return this.font_color;
	}
}
