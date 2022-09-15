package com.DevCommunityApp.App.entity;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "feed")
public class Feed {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "fid_Sequence")
    @SequenceGenerator(name = "fid_Sequence", sequenceName = "FID_SEQ")
	@Column(name="feedId", nullable = false)
	private int feedId;
	@Column(name="query",nullable=false)
	private String query;
	@Column(name="feedDate", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate feedDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name="feedTime", nullable = false)
	private LocalTime feedTime;
	@Column(name="topic", nullable = false)
	private String topic;
	
	@Column(name="relevance", nullable = false)
	private int relevance ;
	
	@Column
	@OneToMany(targetEntity=Response.class,fetch = FetchType.EAGER, mappedBy = "feed", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("feed")
	private List<Feed> feeds;
	
	
	
	@OneToMany(targetEntity=Response.class,fetch = FetchType.EAGER, mappedBy = "feed", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("feed")
	private List<Response> responses;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dev_id", referencedColumnName = "devId")
    @JsonIgnoreProperties("feeds")
	private Developer dev;
	
	@Column(name="totalComments")
	private int totalComments;
	

	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public List<Response> getResponses() {
		return responses;
	}
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
	public int getTotalComments() {
		return totalComments;
	}
	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}
	public Developer getDev() {
		return dev;
	}
	public void setDev(Developer dev) {
		this.dev = dev;
	}
	public Feed() {
		super();
	}
	
	
	public Feed(int feedId, String query, LocalDate feedDate, LocalTime feedTime, String topic, int relevance,
			List<Response> responses, Developer dev, int totalComments) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.topic = topic;
		this.relevance = relevance;
		this.responses = responses;
		this.dev = dev;
		this.totalComments = totalComments;
	}
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
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
		return "Feed [feedId=" + feedId + ", query=" + query + ", feedDate=" + feedDate + ", feedTime=" + feedTime
				+ ", topic=" + topic + ", relevance=" + relevance + ", responses=" + responses + ", dev=" + dev
				+ ", totalComments=" + totalComments + "]";
	}
	
	
}