package com.DevCommunityApp.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevCommunityApp.App.entity.Developer;

@Repository
public interface IDeveloperRepository extends JpaRepository<Developer, Integer>{
	

}