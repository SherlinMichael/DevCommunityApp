package com.DevCommunityApp.App.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="demoresponse")
public class Response {
	  @Id
	  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence1")
	  @SequenceGenerator(name = "id_Sequence1", sequenceName = "ID_SEQ1")
	  private int respId;
	  
	  @Column(name = "answer")
	  private String answer;
	  
	  @Column(name = "Date")
	  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	  private LocalDate respDate;
	  
	  @Column(name = "Time")
	  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	  private LocalTime respTime;
	  
		
		  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		  
		  @JoinColumn(name = "dev_id",referencedColumnName = "devId")
		  
		  @JsonBackReference private Developer dev;
		 
	  
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "feed_id", referencedColumnName = "feedId")
	    @JsonIgnoreProperties("responses")
		private Feed feed;
	  
	public Response() {
	}

	
	  public Developer getDev() { return dev; }
	  
	  public void setDev(Developer dev) { this.dev = dev; }
	 

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public Response(int respId, String answer, LocalDate respDate, LocalTime respTime, Developer dev, Feed feed) {
		super();
		this.respId = respId;
		this.answer = answer;
		this.respDate = respDate;
		this.respTime = respTime;
		this.dev = dev;
		this.feed = feed;
	}
    @Override
		public String toString() {
			return "Response [respId=" + respId + ", answer=" + answer + ", respDate=" + respDate + ", respTime="
					+ respTime + ", dev=" + dev + ", feed=" + feed + "]";
		}
	public int getRespId() {
		return respId;
	}
	public void setRespId(int resp) {
		this.respId = resp;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
    public LocalDate getRespDate() {
    	return respDate;
    }
   public void setRespDate(LocalDate respDate) {
   	this.respDate = respDate;
    }
	public LocalTime getRespTime() {
		return respTime;
	}
	public void setRespTime(LocalTime respTime) {
		this.respTime = respTime;
	}

}