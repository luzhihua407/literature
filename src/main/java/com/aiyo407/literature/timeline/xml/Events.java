package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Events.java
 * @Description TODO
 * @createTime 2021年10月19日 18:27:00
 */
@Data
public class Events {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "event")
	private List<Event> event=new ArrayList<>();
}
