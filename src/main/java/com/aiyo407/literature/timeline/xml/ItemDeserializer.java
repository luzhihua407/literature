package com.aiyo407.literature.timeline.xml;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName ItemDeserializer.java
 * @Description TODO
 * @createTime 2021年10月19日 11:44:00
 */
public class ItemDeserializer extends StdDeserializer<Event> {

	public ItemDeserializer() {
		this(null);
	}

	public ItemDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Event deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		String start = node.get("start").asText();
//		Event event = new Event();
//		event.setStart(start);
		return null;
	}
}
