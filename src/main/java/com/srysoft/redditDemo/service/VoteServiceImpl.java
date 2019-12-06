package com.srysoft.redditDemo.service;

import org.springframework.stereotype.Service;

import com.srysoft.redditDemo.model.Vote;
import com.srysoft.redditDemo.repository.VoteRepository;

@Service
public class VoteServiceImpl implements VoteService {

	private VoteRepository voteRepository;

	public VoteServiceImpl(VoteRepository voteRepository) {
		super();
		this.voteRepository = voteRepository;
	}

	@Override
	public Vote saveVote(Vote vote) {
		return voteRepository.save(vote);
	}

}
