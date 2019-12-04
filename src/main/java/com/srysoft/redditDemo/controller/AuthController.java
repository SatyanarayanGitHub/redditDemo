package com.srysoft.redditDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping(value = "/login")
	public String login() {
		return "auth/login";
	}

}
