package com.DevCommunityApp.App.repository;


import com.DevCommunityApp.App.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository <User, String> {
		
		public User findByName(String userid);
	}