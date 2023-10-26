package com.example.practicecrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SampleController {

	@GetMapping("/")
	public String sayHello() {
		return "HELLO SPRING SECURITY";
	}
	
	@GetMapping("/user")
	public String sayHelloUser() {
		return "HELLO USER THIS IS SPRING SECURITY";
	}
	
	@GetMapping("/admin")
	public String sayHelloAdmin() {
		return "HELLO ADMIN THIS IS SPRING SECURITY";
	}
}
