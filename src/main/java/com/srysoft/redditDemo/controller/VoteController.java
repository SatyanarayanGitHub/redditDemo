package com.srysoft.redditDemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.model.Vote;
import com.srysoft.redditDemo.service.LinkService;
import com.srysoft.redditDemo.service.VoteService;

@RestController
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	
	@Autowired
	private LinkService linkService;
	
	@Secured({"ROLE_USER"})
	@GetMapping("/vote/link/{linkId}/direction/{direction}/votecount/{voteCount}")
	public int vote(@PathVariable Long linkId, @PathVariable short direction, @PathVariable int voteCount) {

		Optional<Link> optionalLinks = linkService.findByIdLink(linkId);
		
		if(optionalLinks.isPresent()) {
			Link link = optionalLinks.get();
			Vote vote = new Vote(direction, link);			
			voteService.saveVote(vote);
			
			int updatedVoteCount = voteCount + direction;
			link.setVoteCount(updatedVoteCount);
			linkService.saveLink(link);
			
			return updatedVoteCount;
		}		
		
		return voteCount;		
	}

}
