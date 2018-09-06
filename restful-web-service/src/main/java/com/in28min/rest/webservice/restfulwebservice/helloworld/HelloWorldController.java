package com.in28min.rest.webservice.restfulwebservice.helloworld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.rest.webservice.restfulwebservice.user.User;
import com.in28min.rest.webservice.restfulwebservice.user.UserDaoService;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping(path= "/hello-world")
	public String HelloWorld(){
		return "Hello World";
	}

	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean HelloWorldBean(String HelloBean){
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s",name ));
	}
	
	
	@RequestMapping(value="/student-details",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public User HelloWorldPost(@RequestBody User user) throws ParseException{
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//		Date date = simpleDateFormat.parse("2012-12-24");
//		User user = new User(01, "test2", date);
		System.out.println("---1--");
		userDaoService.save(user);
		return user;
	}

	
	
}
