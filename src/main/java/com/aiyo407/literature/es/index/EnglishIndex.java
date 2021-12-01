package com.aiyo407.literature.es.index;

import com.aiyo407.literature.english.entity.English;
import com.aiyo407.literature.english.service.IEnglishService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName EnglishIndex.java
 * @Description TODO
 * @createTime 2021年12月01日 09:06:00
 */
@Component
public class EnglishIndex {

//	@Autowired
//	private IEnglishService englishService;

	@Value("${es.host}")
	private String ES_HOST;

	@Autowired
	private RestTemplate rt;

	private  final static String indexAPI="/english";
	private  final static String HTTP="http://";

	public void index() throws IOException {
		File file = ResourceUtils.getFile("classpath:json/english_index.json");
		String reqJson = FileUtils.readFileToString(file, "UTF-8");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> entity = new HttpEntity<String>(reqJson,headers);
		ResponseEntity<byte[]> response = rt.exchange(HTTP+ES_HOST+indexAPI,
				HttpMethod.PUT,
				entity,
				byte[].class);
//		List<English> list = englishService.list();
//		for (int i = 0; i < list.size(); i++) {
//			English english =  list.get(i);
//			String chinese = english.getChinese();
//			String partOfSpeech = english.getPartOfSpeech();
//			String pronunciation = english.getPronunciation();
//			String word = english.getWord();
//
//		}
	}
}
