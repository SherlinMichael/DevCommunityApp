package com.DevCommunityApp.App.service;

import java.util.List;

import com.DevCommunityApp.App.entity.Developer;

public interface IDeveloperService {
	public void addDeveloper(Developer dev);
	public Developer editDeveloper(Developer dev);
	public Developer statusUpdate(Developer dev);
	public Developer getDeveloper(int devId);
	public List<Developer> getAllDevelopers();
	
}