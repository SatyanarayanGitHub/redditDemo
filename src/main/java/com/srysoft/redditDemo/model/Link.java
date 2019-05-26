package com.srysoft.redditDemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Link extends Auditable {

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
	@JsonIgnore
	@OneToMany(mappedBy = "link")
	private List<Comment> comments = new ArrayList<Comment>();
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}

}
