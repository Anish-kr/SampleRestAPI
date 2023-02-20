package com.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
	
		SomeBean someBean = new SomeBean("win","achieve","keep moving");
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters=new SimpleFilterProvider().addFilter("Somebean",filter);
		mappingJacksonValue.setFilters(filters);
		
		
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
	
		return Arrays.asList(new SomeBean("win","achieve","keep moving"),
				new SomeBean("happy","satisfied","neutral"));
		
	}
}
