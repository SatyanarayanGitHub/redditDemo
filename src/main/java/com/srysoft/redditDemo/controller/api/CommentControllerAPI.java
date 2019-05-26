package com.srysoft.redditDemo.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srysoft.redditDemo.model.Comment;
import com.srysoft.redditDemo.repository.CommentRepository;

@RestController
@RequestMapping("/api/comment")
public class CommentControllerAPI {

	private CommentRepository commentRepository;

	public CommentControllerAPI(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	//list
	@GetMapping("/")
	public List<Comment> list() {
		return commentRepository.findAll();
	}

	//Create

	//Read
	@GetMapping("/{id}")
	public Optional<Comment> read(@PathVariable Long id) {
		return commentRepository.findById(id);
	}

}
