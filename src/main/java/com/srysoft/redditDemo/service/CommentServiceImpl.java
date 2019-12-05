package com.srysoft.redditDemo.service;

import org.springframework.stereotype.Service;

import com.srysoft.redditDemo.model.Comment;
import com.srysoft.redditDemo.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;

	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
