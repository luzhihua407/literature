package com.aiyo407.literature.timeline.xml;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2021年10月19日 10:26:00
 */
public class View
{
	private Displayed_period displayed_period;

	private String hidden_categories;

	public void setDisplayed_period(Displayed_period displayed_period){
		this.displayed_period = displayed_period;
	}
	public Displayed_period getDisplayed_period(){
		return this.displayed_period;
	}
	public void setHidden_categories(String hidden_categories){
		this.hidden_categories = hidden_categories;
	}
	public String getHidden_categories(){
		return this.hidden_categories;
	}
}
