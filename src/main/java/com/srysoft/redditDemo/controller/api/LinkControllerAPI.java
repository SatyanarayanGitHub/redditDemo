package com.srysoft.redditDemo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.repository.LinkRepository;

@RequestMapping("/api/link")
@RestController
public class LinkControllerAPI {

	private LinkRepository linkRepository;

	public LinkControllerAPI(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}

	//list
	@GetMapping("/")
	public List<Link> lists() {
		return linkRepository.findAll();
	}

	//Create
	@PostMapping("/create")
	public Link create(@RequestBody Link link) {
		return linkRepository.save(link);
	}

	//Read
	@GetMapping("/{id}")
	public Optional<Link> read(@PathVariable Long id) {
		return linkRepository.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public Link update(@PathVariable Long id, @RequestBody Link link) {
		// get the id
		return linkRepository.save(link);
	}

	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		linkRepository.deleteById(id);
	}

}
