package com.srysoft.redditDemo.service;

import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.srysoft.redditDemo.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailService {

	private final JavaMailSender javaMailSender;
	private final SpringTemplateEngine templateEngine;
	private final String BASE_URL = "http://localhost:8080";

	public MailService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
	}

	@Async
	public void sendEmail(String to, String subject, String content, boolean isMultiPart, boolean isHtml) {
		log.info("Sending Email");

		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
			messageHelper.setTo(to);
			messageHelper.setFrom("noreply@springbootdemo.com");
			messageHelper.setSubject(subject);
			messageHelper.setText(content, isHtml);

			javaMailSender.send(mimeMessage);

		} catch (Exception e) {
			log.warn("Email could not be sent to user '{}' : {}", to, e.getMessage());
		}

	}

	@Async
	public void sendEmailFromTemplate(User user, String templateName, String subject) {
		Locale locale = Locale.ENGLISH;
		Context context = new Context(locale);

		context.setVariable("user", user);
		context.setVariable("baseURL", BASE_URL);

		String content = templateEngine.process(templateName, context);
		sendEmail(user.getEmail(), subject, content, false, true);

	}

	@Async
	public void sendActivationEmail(User user) {
		log.debug("Sending activatin email to '{}'", user.getEmail());
		sendEmailFromTemplate(user, "email/activation", "Satyanarayan Spring Boot Demo App - User Activation");
	}

	public void sendWelcomeEmail(User user) {
		log.debug("Sending welcome email to '{}'", user.getEmail());
		sendEmailFromTemplate(user, "email/welcome", "Satyanarayan Spring Boot Demo App - Welcome User");
	}

}
