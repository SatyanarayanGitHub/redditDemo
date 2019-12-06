package com.srysoft.redditDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.srysoft.redditDemo.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping(value = "/profile")
	public String profile() {
		return "auth/profile";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "auth/register";
	}

}
