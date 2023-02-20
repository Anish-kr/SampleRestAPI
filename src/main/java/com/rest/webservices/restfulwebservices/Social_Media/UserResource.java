package com.rest.webservices.restfulwebservices.Social_Media;


import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {

	private UserDauService service;
	
	public UserResource(UserDauService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<Users> retrieveAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<Users> retrieveuser(@PathVariable int id)
	{
		Users user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<Users> entityModel= EntityModel.of(user);
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAll());
		entityModel.add(link.withRel("all_users"));
		
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Users> postUser(@Valid @RequestBody Users user) {
		Users saveduser=service.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveduser.getAge())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
}
