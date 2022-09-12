package com.DevCommunityApp.App.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "feed")
public class Feed {
	@Id
	@GeneratedValue
	@Column(name="feedId")
	private long feedId;
	@Column(name="query",nullable=false)
	private String query;
	@Column(name="feedDate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate feedDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name="feedTime")
	private LocalTime feedTime;
	@Column(name="topic")
	private String topic;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dev_id", referencedColumnName = "devId")
    @JsonIgnoreProperties("feeds")
	private Developer dev;
	

	public Developer getDev() {
		return dev;
	}
	public void setDev(Developer dev) {
		this.dev = dev;
	}
	public Feed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feed(long feedId, String query, LocalDate feedDate, LocalTime feedTime, String topic) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.topic = topic;
	}
	public long getFeedId() {
		return feedId;
	}
	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public LocalDate getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
	}
	public LocalTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(LocalTime feedTime) {
		this.feedTime = feedTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "FeedEntity [feedId=" + feedId + ", query=" + query + ", feedDate=" + feedDate + ", feedTime=" + feedTime
				+ ", topic=" + topic + "]";
	}
	
}
