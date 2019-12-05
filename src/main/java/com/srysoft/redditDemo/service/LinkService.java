package com.srysoft.redditDemo.service;

import java.util.List;
import java.util.Optional;

import com.srysoft.redditDemo.model.Link;

public interface LinkService {

	List<Link> findAllLinks();

	Optional<Link> findByIdLink(Long id);
	
	Link saveLink(Link link);

}
