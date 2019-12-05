package com.srysoft.redditDemo.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Comment extends Auditable {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String body;

	/**
	 * Many To One - Many comments connect one Link
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	private Link link;

	public Comment(@NonNull String body, Link link) {
		this.body = body;
		this.link = link;
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
