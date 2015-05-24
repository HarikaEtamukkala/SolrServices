package com.accolite.solrservices;

import java.util.Arrays;

import net.minidev.json.JSONObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {
	@RequestMapping(value = "/search/{query}/{type}/", method = RequestMethod.GET)
public JSONObject searchQuery(@PathVariable String query,@PathVariable String type){
	RestTemplate restTemplate = new RestTemplate();
	String url="http://localhost:8983/solr/todo/select?q="+query+"&wt"+type;
	/*String response = restTemplate.getForObject( url,
	        String.class);*/
	
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

	ResponseEntity<String> response = 
			restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	JSONObject jsonList = new JSONObject();
	jsonList.put("json", response);
	System.out.println(response);
	return jsonList;
}
	
}
