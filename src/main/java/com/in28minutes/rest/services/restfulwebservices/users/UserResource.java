package com.in28minutes.rest.services.restfulwebservices.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id)
	{
		User user = userDaoService.findOne(id);
		if(user==null)
		{
			//return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
			throw new UserNotFoundException("Id = "+id);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity saveUser(@Valid @RequestBody User user)
	{
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/exception")
	public void exceptionCheck()
	{
		userDaoService.exceptionCheck();
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user = userDaoService.deleteUser(id);
		if(user==null)
			throw new UserNotFoundException("id = "+id);
	}
	//a
	//b
	//c
}
