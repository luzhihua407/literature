package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2021年10月19日 10:26:00
 */
@Data
public class View
{
	@JacksonXmlProperty(localName = "displayed_period")
	private Displayed_period displayedPeriod;

	@JacksonXmlProperty(localName = "hidden_categories")
	private String hiddenCategories;

}
