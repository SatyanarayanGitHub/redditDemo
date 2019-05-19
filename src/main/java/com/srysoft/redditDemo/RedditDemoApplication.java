package com.srysoft.redditDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(RedditDemoApplication.class);

	public static void main(String[] args) {
		log.info("==>> Application Start!!");
		SpringApplication.run(RedditDemoApplication.class, args);
	}
	
	

}
