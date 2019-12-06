package com.srysoft.redditDemo;

import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@SpringBootApplication
@EnableTransactionManagement
public class RedditDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(RedditDemoApplication.class);

	public static void main(String[] args) {
		log.info("==>> Application Start!!");
		SpringApplication.run(RedditDemoApplication.class, args);
	}
	
	@Bean
	PrettyTime prettyTime() {
		return new PrettyTime();
	}

	
	// TODO * Configuring this bean should not be needed once Spring Boot's Thymeleaf starter includes configuration
	// TODO   for thymeleaf-extras-springsecurity5 (instead of thymeleaf-extras-springsecurity4)
	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

	/**
	 * Reference Link 
	 * 1. https://github.com/danvega/springit-course-docs 
	 * 2. https://github.com/danvega/springit-templates
	 * 3. https://www.danvega.dev/blog/2018/03/01/what-is-new-spring-boot-2/
	 * 
	 */

}
