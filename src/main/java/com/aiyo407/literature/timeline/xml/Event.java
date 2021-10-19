package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@JsonIgnoreProperties(ignoreUnknown=true)
public class Event
{
	private String start;

	private String end;

	private String text;

	@JacksonXmlProperty(localName = "fuzzy")
	private Boolean fuzzy;

	@JacksonXmlProperty(localName = "fuzzy_start")
	private Boolean fuzzyStart;

	@JacksonXmlProperty(localName = "fuzzy_end")
	private Boolean fuzzyEnd;

	@JacksonXmlProperty(localName = "locked")
	private Boolean locked;

	@JacksonXmlProperty(localName = "ends_today")
	private Boolean endsToday;

	@JacksonXmlProperty(localName = "category")
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
	private String category;

	/**
	 * 描述
	 */
	@JacksonXmlProperty(localName = "description")
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
	private String description;

	/**
	 * 标签
	 */
	@JacksonXmlProperty(localName = "labels")
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
	private String labels;

	@JacksonXmlProperty(localName = "default_color")
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
	private String defaultColor;


}


