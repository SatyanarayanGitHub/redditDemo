package com.srysoft.redditDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String body;

	// user
	// link

}
