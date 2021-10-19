package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2021年10月19日 10:26:00
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root
{
	private Timeline timeline;

	public void setTimeline(Timeline timeline){
		this.timeline = timeline;
	}
	public Timeline getTimeline(){
		return this.timeline;
	}
}
