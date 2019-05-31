package com.srysoft.redditDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srysoft.redditDemo.model.Hello;
import com.srysoft.redditDemo.repository.HelloRepository;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HelloRepository helloRepository;

	@Override
	public String get() {
		return "Hello Junit 5";
	}

	@Override
	public Hello create(Hello hello) {
		hello = helloRepository.save(hello);
		return hello;
		
	}

}
