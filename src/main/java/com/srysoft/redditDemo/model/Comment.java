package com.srysoft.redditDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Comment extends Auditable {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String body;
	
	/**
	 * Many To One - Many comments connect one Link
	 */
	@ManyToOne
	private Link link;
	
}
