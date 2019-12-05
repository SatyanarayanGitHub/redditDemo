package com.srysoft.redditDemo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srysoft.redditDemo.model.Comment;
import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.repository.CommentRepository;
import com.srysoft.redditDemo.service.LinkService;

@RequestMapping("/link")
@Controller
public class LinkController {

	private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
	private LinkService linkService;

	@Autowired
	private CommentRepository commentRepository;

	public LinkController(LinkService linkService) {
		logger.info("==>> Link Controller");
		this.linkService = linkService;
	}

	@GetMapping("/")
	public String lists(Model model) {
		model.addAttribute("links", linkService.findAllLinks());
		return "link/list";
	}

	@GetMapping("/{id}")
	public String read(@PathVariable Long id, Model model) {
		Optional<Link> link = linkService.findByIdLink(id);

		if (link.isPresent()) {
			Link currentLink = link.get();
			Comment comment = new Comment();
			comment.setLink(currentLink);
			model.addAttribute("comment", comment);

			model.addAttribute("link", link.get());
			model.addAttribute("success", model.containsAttribute("success"));

			return "link/view";
		} else {

			return "redirect:/";
		}
	}

	@GetMapping("/submit")
	public String newLinkForm(Model model) {
		model.addAttribute("link", new Link());
		return "link/submit";
	}

	@PostMapping("/submit")
	public String createLink(@Valid Link link, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			logger.info("Validation error was found while submitting  a new link");
			model.addAttribute("link", link);

			return "link/submit";
		} else {
			//save our link
			linkService.saveLink(link);
			logger.info("==>> New link was saved successfully.");
			redirectAttributes.addAttribute("id", link.getId()).addFlashAttribute("success", true);

			return "redirect:/link/{id}";

		}
		//return "link/submit";
	}

	@Secured({ "ROLE_USER" })
	@PostMapping("/comments")
	public String addComment(@Valid Comment comment, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			logger.info("==>> There was a problem adding a new comment.");
		} else {
			commentRepository.save(comment);
			logger.info("==>> New comment was saved successfully.");

			redirectAttributes.addAttribute("commentId", comment.getId()).addFlashAttribute("commentsuccess", true);
		}

		return "redirect:/link/" + comment.getLink().getId();
	}
}
