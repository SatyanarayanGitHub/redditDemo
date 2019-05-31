package com.srysoft.redditDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srysoft.redditDemo.model.Hello;

public interface HelloRepository extends JpaRepository<Hello, Long> {
	
	 

}
