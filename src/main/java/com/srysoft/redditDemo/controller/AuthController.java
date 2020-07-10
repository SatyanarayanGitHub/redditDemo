package com.srysoft.redditDemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srysoft.redditDemo.model.User;
import com.srysoft.redditDemo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String register(Model model) {
		model.addAttribute("user", new User());
		//model.addAttribute("success", false);
		return "auth/register";
	}

	@PostMapping("/register")
	public String regiterNewUser(@Valid User user, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			log.info("Validation errors were found while registration a new user");
			model.addAttribute("user", user);
			model.addAttribute("validationErrors", bindingResult.getAllErrors());

			return "auth/register";
		} else {
			User newUser = userService.register(user);
			redirectAttributes.addAttribute("id", newUser.getId());
			redirectAttributes.addFlashAttribute("success", true);

			return "redirect:/register";
		}
	}

}
