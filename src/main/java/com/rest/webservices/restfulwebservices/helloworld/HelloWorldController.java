package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/helloworld")
	public String helloworld() {
		return "Hello_World";
	}
	
	@GetMapping(path="/helloworldbean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path="/helloworld/{name}")
	public HelloWorldBean helloworldbean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World_path, %s", name));
	}
	
	
	
}
