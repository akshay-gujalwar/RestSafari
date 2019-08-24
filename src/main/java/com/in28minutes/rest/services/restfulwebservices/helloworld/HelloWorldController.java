package com.in28minutes.rest.services.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World Bean");
	}
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean getPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello %s to the World", name));
	}
	
}
