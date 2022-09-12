package com.example.DevCommunityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DevCommunityApp.entity.Developer;

@Repository
public interface IDeveloperRepository extends JpaRepository<Developer, Integer>{
	

}
