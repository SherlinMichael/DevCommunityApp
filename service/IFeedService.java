package com.DevCommunityApp.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevCommunityApp.App.entity.Feed;
//import com.DevCommunityApp.App.entity.User;
import com.DevCommunityApp.App.repository.IFeedRepository;
@Service
public class IFeedService {
	@Autowired
	private IFeedRepository feedRepository;
	
//Method to ADD Feed
	public Feed addFeed(Feed f) {
		return feedRepository.save(f);
	}
	
//Method to GET all feed
	 public List<Feed> listAllUser() {
	        return feedRepository.findAll();
	    }
//Method to edit/update Feed
	public Feed editFeed(Feed f) {
		Optional<Feed> oldfeed = feedRepository.findById(f.getFeedId());
		Feed newFeed=oldfeed.get();
		newFeed.setFeedDate(f.getFeedDate());
		newFeed.setFeedTime(f.getFeedTime());
		newFeed.setQuery(f.getQuery());
		newFeed.setTopic(f.getTopic());
		newFeed.setRelevance(f.getRelevance());
		newFeed.setResponses(f.getResponses());
		newFeed.setTotalComments(f.getTotalComments());
		newFeed.setDev(f.getDev());
		newFeed=feedRepository.save(newFeed);
		return newFeed;
	}
//Method to like the feed
	public Feed likeFeed(int feedid) {
		Optional<Feed> d = feedRepository.findById(feedid);
		Feed newFeed=d.get();
		newFeed.setRelevance(d.get().getRelevance()+1);
		newFeed=feedRepository.save(newFeed);
		return newFeed;
	}
//Method to get feed by id
	public Feed getFeed(int feedid) {
		return feedRepository.findById(feedid).get();
	}
//Method to delete feed by id
	public void removeFeed(int feedid) {
		 feedRepository.deleteById(feedid);
	}

	public Feed findById(int feedId) {
		return feedRepository.findById(feedId).get();
	}

	
	  public Feed findById1(int feedId) { return
	  feedRepository.findById(feedId).get(); }
	 

	

	



	 
	
}