package com.srysoft.redditDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/home" })
	public String home(Model model) {

		model.addAttribute("title", "Home");
		model.addAttribute("message", "Hello, Spring Boot Application with View Template Engine- Thymeleaf");
		return "home";
	}

}
