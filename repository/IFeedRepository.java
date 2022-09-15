package com.DevCommunityApp.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevCommunityApp.App.entity.Developer;
import com.DevCommunityApp.App.entity.Feed;

public interface IFeedRepository extends JpaRepository<Feed, Integer> {
	public List<Feed> findByDev(Developer dev);
	public List<Feed> findByTopic(String topic);
}