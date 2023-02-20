package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	//versioning URI---------------->
	@GetMapping("/v1/person")
	public String personV1()
	{
		return "Bob Charlie";
	}
	
	@GetMapping("/v2/person")
	public Name personV2()
	{
		return new Name("Bob","Charlie");
	}
	
	//versioning using parameters------->
	@GetMapping(path="/person",params="version-1")
	public String personV1usingparam()
	{
		return "Bob Charlie";
	}
	
	@GetMapping(path="/person",params="version-2")
	public Name personV2usingparam()
	{
		return new Name("Bob","Charlie");
	}
	
	
	//versioning using header------->
		@GetMapping(path="/person/header",headers="version=1")
		public String personV1usingHeader()
		{
			return "Bob Charlie";
		}
		
		@GetMapping(path="/person/header",headers="version=2")
		public Name personV2usingHeader()
		{
			return new Name("Bob","Charlie");
		}
	
		
		
		//Media-Type versioning ------->
				@GetMapping(path="/person/acept",headers="application/vnd.company.app-v1+json")
				public String personV1byAcceptHeader()
				{
					return "Bob Charlie";
				}
				
				@GetMapping(path="/person/accept",headers="application/vnd.company.app-v2+json")
				public Name personV2byAcceptHeader()
				{
					return new Name("Bob","Charlie");
				}
}
