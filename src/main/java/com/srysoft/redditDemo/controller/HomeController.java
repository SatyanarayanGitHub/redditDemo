package com.srysoft.redditDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping(value = { "/", "/home" })
	public String home() {
		return ("Welcome to Spring 2 Demo, Appliation!!");
	}

}
