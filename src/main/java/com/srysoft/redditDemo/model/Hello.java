package com.srysoft.redditDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hello {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String message;

	public Hello() {

	}

	public Hello(String name, String message) {
		//this.id = id;
		this.name = name;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Hello [id=" + id + ", name=" + name + ", message=" + message + "]";
	}

}
