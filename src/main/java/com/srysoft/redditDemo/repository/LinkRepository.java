package com.srysoft.redditDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srysoft.redditDemo.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

	Link findByTitle(String tile);

}
