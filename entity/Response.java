package com.demo.DevCom.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demoresponse")

public class Response {

	  @Id
	  private int respId;
	  
	  @Column(name = "Answer")
	  private String answer;
	  
	  @Column(name = "Date")
	  private LocalDate respDate;
	  
	  @Column(name = "Time")
	  private LocalTime respTime;
	  
	public Response() {
	}
	public Response(int respId, String answer) {
			super();
			this.respId = respId;
			this.answer = answer;
		} 
	public int getRespId() {
		return respId;
	}
	public void setRespId(int respId) {
		this.respId = respId;
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
