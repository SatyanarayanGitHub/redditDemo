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
	
	/*

	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository, HomeService homeService) {
		return args -> {
			log.info("<<-----------Command Line Runner ----------->>");
			Link link = new Link("Spring Boot 2 Swagger", "https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg");
			linkRepository.save(link);
			

			Comment comment = new Comment("Swagger doc, what a document", link);
			commentRepository.save(comment);
			link.addComment(comment);
			
			
			Hello hello1 = new Hello("Satya", "Welcome! Satya");
			Hello hello2 = new Hello("Ronak", "Welcome! Ronak");
			Hello hello3 = new Hello("Nikhil", "Welcome! Nikhil");
			Hello hello4 = new Hello("Kailash", "Welcome! Kailash");
			
			homeService.create(hello1);
			homeService.create(hello2);
			homeService.create(hello3);
			homeService.create(hello4);
			
		
		};
	}
	
	*/
	/**
	 * Reference Link 
	 * 1. https://github.com/danvega/springit-course-docs 
	 * 2. https://github.com/danvega/springit-templates
	 * 3. https://www.danvega.dev/blog/2018/03/01/what-is-new-spring-boot-2/
	 * 
	 */

}
