package com.srysoft.redditDemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Link {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String title;

	@NonNull
	private String url;

	/**
	 *  one to many - one link has many comments
	 */
	@OneToMany(mappedBy = "link")
	private List<Comment> comments = new ArrayList<Comment>();
}
