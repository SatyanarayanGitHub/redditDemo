package com.srysoft.redditDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

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
