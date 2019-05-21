package com.srysoft.redditDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srysoft.redditDemo.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
