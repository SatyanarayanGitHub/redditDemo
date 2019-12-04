package com.srysoft.redditDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srysoft.redditDemo.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
