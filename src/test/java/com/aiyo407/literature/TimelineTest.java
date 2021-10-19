package com.aiyo407.literature;

import com.aiyo407.literature.timeline.entity.TimelineEvent;
import com.aiyo407.literature.timeline.service.IEventService;
import com.aiyo407.literature.timeline.xml.Event;
import com.aiyo407.literature.timeline.xml.Events;
import com.aiyo407.literature.timeline.xml.Timeline;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName TimelineTest.java
 * @Description TODO
 * @createTime 2021年10月19日 09:03:00
 */
@SpringBootTest
public class TimelineTest {

	@Autowired
	private IEventService eventService;

	@Test
	void run() throws IOException, InvocationTargetException, IllegalAccessException {
//		List<TimelineEvent> list=new ArrayList<>();
//		File file = new File("C:\\Users\\86137\\Documents\\WeChat Files\\wxid_0458084583912\\FileStorage\\File\\2021-10\\史记.timeline");
//		ObjectMapper xmlMapper = new XmlMapper();
//		Timeline timeline = xmlMapper.readValue(file, Timeline.class);
//		List<Event> events = timeline.getEvents();
//		for (int i = 0; i < events.size(); i++) {
//			Event event =  events.get(i);
//			TimelineEvent e = new TimelineEvent();
//			e.setStart(event.getStart());
//			e.setEnd(event.getEnd());
//			e.setText(event.getText());
//			e.setDefaultColor(event.getDefaultColor());
//			e.setDescription(event.getDescription());
//			e.setLabels(event.getLabels());
//			list.add(e);
//
//		}
//		eventService.saveBatch(list);
	}

	@Test
	public void generatorXML() throws IOException {
		Timeline timeline = new Timeline();
		Events events = new Events();
		List<Event> eventList=new ArrayList<>();
		List<TimelineEvent> list = eventService.list();
		for (int i = 0; i < list.size(); i++) {
			TimelineEvent timelineEvent =  list.get(i);
			Event event = new Event();
			BeanUtils.copyProperties(timelineEvent,event);
			eventList.add(event);
		}
		events.setEvent(eventList);
		timeline.setEvents(events);
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
		String xml = xmlMapper.writeValueAsString(timeline);
		FileUtils.write(new File("D://史记.timeline"),xml,"UTF-8");
		System.err.println(xml);
	}
}
