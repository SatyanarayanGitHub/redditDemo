package com.srysoft.redditDemo.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *  
 * @author SATYA
 *
 * Using ApplicationContextAware in Spring
 * Reference: https://www.dineshonjava.com/using-applicationcontextaware-in-spring/
 */
@Service
public class BeanUtil implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}
}
