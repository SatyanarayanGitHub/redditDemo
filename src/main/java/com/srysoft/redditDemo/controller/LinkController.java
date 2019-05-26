package com.srysoft.redditDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.repository.LinkRepository;

@RequestMapping("/link")
@Controller
public class LinkController {

	private LinkRepository linkRepository;

	public LinkController(LinkRepository linkRepository) {
		super();
		this.linkRepository = linkRepository;
	}

	//list
	@GetMapping("/")
	public List<Link> lists() {
		return linkRepository.findAll();
	}

	//Create
	@PostMapping("/create")
	public Link create(@ModelAttribute Link link) {
		return linkRepository.save(link);
	}

	//Read
	@GetMapping("/{id}")
	public Optional<Link> read(@PathVariable Long id) {
		return linkRepository.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public Link update(@PathVariable Long id, @ModelAttribute Link link) {
		// get the id
		return linkRepository.save(link);
	}

	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		linkRepository.deleteById(id);
	}

}
