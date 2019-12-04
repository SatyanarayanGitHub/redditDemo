package com.srysoft.redditDemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.model.Vote;
import com.srysoft.redditDemo.repository.LinkRepository;
import com.srysoft.redditDemo.repository.VoteRepository;

@RestController
public class VoteController {
	
	@Autowired
	private VoteRepository voteRepository;
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Secured({"USER"})
	@GetMapping("/vote/link/{linkId}/direction/{direction}/votecount/{voteCount}")
	public int vote(@PathVariable Long linkId, @PathVariable short direction, @PathVariable int voteCount) {

		Optional<Link> optionalLinks = linkRepository.findById(linkId);
		
		if(optionalLinks.isPresent()) {
			Link link = optionalLinks.get();
			Vote vote = new Vote(direction, link);			
			voteRepository.save(vote);
			
			int updatedVoteCount = voteCount + direction;
			link.setVoteCount(updatedVoteCount);
			linkRepository.save(link);
			
			return updatedVoteCount;
		}		
		
		return voteCount;		
	}

}
