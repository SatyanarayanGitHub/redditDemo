package com.srysoft.redditDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.srysoft.redditDemo.model.Comment;
import com.srysoft.redditDemo.model.Link;
import com.srysoft.redditDemo.repository.CommentRepository;
import com.srysoft.redditDemo.repository.LinkRepository;

@SpringBootApplication
public class RedditDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(RedditDemoApplication.class);

	public static void main(String[] args) {
		log.info("==>> Application Start!!");
		SpringApplication.run(RedditDemoApplication.class, args);
	}

	//@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			log.info("<<-----------Command Line Runner ----------->>");
			Link link = new Link("Spring Boot 2 Swagger", "https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg");
			linkRepository.save(link);
			

			Comment comment = new Comment("Swagger doc, what a document", link);
			commentRepository.save(comment);
			link.addComment(comment);	
		
		};
	}

}
