package com.srysoft.redditDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.srysoft.redditDemo.model.Hello;
import com.srysoft.redditDemo.service.HomeService;

@SpringBootTest
public class HomeServiceTest {

	@Autowired
	HomeService homeService;

	@BeforeAll
	static void setup() {
		System.out.println("==> @BeforeAll executed");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("======>> @BeforeEach executed");
	}

	@Test
	void testGet() {
		String getMessage = homeService.get();

		assertEquals("Hello Junit 5", getMessage);
	}

	@DisplayName("Test Case for Create Hello Object")
	@Test
	void testCreateHello() {
		Hello hello = new Hello("TestName", "Any message for test");
		assertNull(hello.getId());

		Hello hello1 = homeService.create(hello);
		assertNotNull(hello1.getId());
	}

	@AfterEach
	void tearThis() {
		System.out.println("==>> @AfterEach executed");
	}

	@AfterAll
	static void tear() {
		System.out.println("======>> @AfterAll executed");
	}
}
