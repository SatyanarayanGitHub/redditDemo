package com.srysoft.redditDemo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Vote extends Auditable {

	public Vote(short direction, Link link) {
		this.direction = direction;
		this.link = link;
	}

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private short direction;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Link link;

	// user
	// link

}
