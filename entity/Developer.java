package com.example.DevCommunityApp.entity;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.Email;

@Entity
@DynamicUpdate
@Table(name = "developer")
public class Developer {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private int devId;
	
	@NotNull
    @Size(max = 30)
	private String name;
	
	@NotNull
    @Email
    @Size(max = 50)
    @Column(unique = true)
	private String email;
	 @Column
	private String skillLevel;
	 @Column
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate memberSince;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "dev")
	@JsonManagedReference
	private User user;
	
	@OneToMany(targetEntity=Feed.class,fetch = FetchType.EAGER, mappedBy = "dev", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("dev")
	private List<Feed> feeds;
	
	 @Column
	private int totalFeeds;
	 @Column
	private int reputation;
	 @Column
	private boolean isVerified;
	 @Column
	private boolean isBlocked;
	
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Developer(int devId, String name, String email, String skillLevel, LocalDate memberSince, User user,
			List<Feed> feeds, int totalFeeds, int reputation, boolean isVerified, boolean isBlocked) {
		super();
		this.devId = devId;
		this.name = name;
		this.email = email;
		this.skillLevel = skillLevel;
		this.memberSince = memberSince;
		this.user = user;
		this.feeds = feeds;
		this.totalFeeds = totalFeeds;
		this.reputation = reputation;
		this.isVerified = isVerified;
		this.isBlocked = isBlocked;
	}

	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", name=" + name + ", email=" + email + ", skillLevel=" + skillLevel
				+ ", memberSince=" + memberSince + ", user=" + user + ", totalFeeds=" + totalFeeds + ", reputation="
				+ reputation + ", isVerified=" + isVerified + ", isBlocked=" + isBlocked + "]";
	}
	//Getters Setters
	
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Feed> getFeeds() {
		return feeds;
	}
	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}
	public int getTotalFeeds() {
		return totalFeeds;
	}
	public void setTotalFeeds(int totalFeeds) {
		this.totalFeeds = totalFeeds;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	
}
