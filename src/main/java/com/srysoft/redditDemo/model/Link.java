package com.srysoft.redditDemo.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srysoft.redditDemo.service.BeanUtil;

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
	@NotEmpty(message = "Please enter a title")
	private String title;

	@NonNull
	@NotEmpty(message = "Please enter a url")
	@URL(message = "Please enter a valid url")
	private String url;

	/**
	 *  one to many - one link has many comments
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "link", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();

	@OneToMany(mappedBy = "link", fetch = FetchType.LAZY)
	private List<Vote> votes = new ArrayList<Vote>();
		
	private int voteCount = 0;
	
	@ManyToOne
	private User user;

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	@JsonIgnore
	public String getDomainName() throws URISyntaxException {
		URI uri = new URI(this.url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	@JsonIgnore
	public String getPrettyTime() {
		PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
		return pt.format(convertToDateViaInstant(getCreatedDate()));
	}

	@JsonIgnore
	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

}
