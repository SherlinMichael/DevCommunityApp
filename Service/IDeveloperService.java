package com.example.DevCommunityApp.service;

import java.util.List;

import com.example.DevCommunityApp.entity.Developer;

public interface IDeveloperService {
	public Developer addDeveloper(Developer dev);
	public Developer editDeveloper(Developer dev);
	public Developer statusUpdate(Developer dev);
	public Developer getDeveloper(int devId);
	public List<Developer> getAllDevelopers();
	
}
