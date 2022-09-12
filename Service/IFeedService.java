package com.example.feeduser.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feeduser.exception.RecordNotFoundException;
import com.example.feeduser.model.FeedEntity;
import com.example.feeduser.repository.FeedRepository;
@Service
public class FeedServices {
	     
	    @Autowired
	    public FeedRepository repository;
	     
	    public List<FeedEntity> getAllFeeds()
	    {
	        List<FeedEntity> feedList = (List<FeedEntity>) repository.findAll();
	         
	        if(feedList.size() > 0) {
	            return feedList;
	        } else {
	            return new ArrayList<FeedEntity>();
	        }
	    }
	     
	    public FeedEntity getFeedsById(Long id) throws RecordNotFoundException 
	    {
	        Optional<FeedEntity> feed = repository.findById(id);
	         
	        if(feed.isPresent()) {
	            return feed.get();
	        } else {
	            throw new RecordNotFoundException("No feed is exist");
	        }
	    }
	     
	    public FeedEntity createOrUpdateFeed(FeedEntity entity) throws RecordNotFoundException 
	    {
	        Optional<FeedEntity> feed = repository.findById(entity.getFeedId());
	         
	        if(feed.isPresent()) 
	        {
	            FeedEntity newEntity = feed.get();
	            newEntity.setQuery(entity.getQuery());
	            newEntity.setTopic(entity.getTopic());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    } 
	     
	    public void removeFeed(Long id) throws RecordNotFoundException 
	    {
	        Optional<FeedEntity> feed = repository.findById(id);
	         
	        if(feed.isPresent()) 
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No feed exist");
	        }
	    } 
	
}
