package com.srysoft.redditDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.repository.LinkRepository;

@Service
public class LinkServiceImpl implements LinkService {

	private LinkRepository linkRepository;

	public LinkServiceImpl(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}

	@Override
	public List<Link> findAllLinks() {
		return linkRepository.findAll();
	}

	@Override
	public Optional<Link> findByIdLink(Long id) {
		return linkRepository.findById(id);
	}

	@Override
	public Link saveLink(Link link) {
		return linkRepository.save(link);
	}

}
