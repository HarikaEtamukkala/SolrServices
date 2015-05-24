package com.accolite.solrservices;

import java.util.Arrays;

import net.minidev.json.JSONArray;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accolite.solrservices.beans.PostBean;

@RestController
public class IndexController {
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json",
			value = "/indexing")
	public Object indexData(@RequestBody JSONArray bean){
		System.out.println("Title is :"+bean);
		System.out.println("Title is :"+bean.get(1));
		
		final String url ="http://localhost:8983/solr/update/json?commit=true";
		
		RestTemplate restTemplate= new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = 
				restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

/*Object response = 
				restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);*/
		  /*Object result = restTemplate.postForObject( url, bean, Object.class);*/
		 System.out.println(result);
		return result;
	}

}
