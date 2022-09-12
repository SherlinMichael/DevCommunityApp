package com.example.DevCommunityApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DevCommunityApp.entity.Developer;
import com.example.DevCommunityApp.repository.IDeveloperRepository;

@Service
public class IDeveloperServiceImpl implements IDeveloperService{
	@Autowired
	private IDeveloperRepository developerRepository;
	@Override
	public Developer addDeveloper(Developer dev) {
		return developerRepository.save(dev);
	}

	@Override
	public Developer editDeveloper(Developer dev) {
		Optional<Developer> d = developerRepository.findById(dev.getDevId());
		Developer newDeveloper=d.get();
		newDeveloper.setName(dev.getName());
		newDeveloper.setEmail(dev.getEmail());
		newDeveloper.setSkillLevel(dev.getSkillLevel());
		newDeveloper.setMemberSince(dev.getMemberSince());
		newDeveloper.setUser(dev.getUser());
		newDeveloper.setFeeds(dev.getFeeds());
		newDeveloper.setTotalFeeds(dev.getTotalFeeds());
		newDeveloper.setReputation(dev.getReputation());
		newDeveloper.setVerified(dev.isVerified());
		newDeveloper.setBlocked(dev.isBlocked());
		newDeveloper=developerRepository.save(newDeveloper);
		return newDeveloper;
	}

	@Override
	public Developer statusUpdate(Developer dev) {
		Optional<Developer> d = developerRepository.findById(dev.getDevId());
		Developer newDeveloper=d.get();
		newDeveloper.setVerified(dev.isVerified());
		newDeveloper.setBlocked(dev.isBlocked());
		newDeveloper=developerRepository.save(newDeveloper);
		return newDeveloper;
		
	}

	@Override
	public Developer getDeveloper(int devId) {
		return developerRepository.findById(devId).get();
	}

	@Override
	public List<Developer> getAllDevelopers() {
		return developerRepository.findAll();
	}

}
