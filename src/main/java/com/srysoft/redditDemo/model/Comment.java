package com.srysoft.redditDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
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

	public Comment(@NonNull String body, Link link) {
		this.body = body;
		this.link = link;
	}

}
