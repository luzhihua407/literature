package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2021年10月19日 10:26:00
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@JacksonXmlRootElement(localName = "timeline")
public class Timeline
{
	private String version="2.5.0";

	private String timetype="gregoriantime";

	@JacksonXmlProperty(localName = "categories")
	private Categories categories;

	@JacksonXmlProperty(localName = "events")
	private Events events;

	@JacksonXmlProperty(localName = "view")
	private View view;

}
