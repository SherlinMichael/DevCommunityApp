package com.DevCommunityApp.App.controller;

import java.util.List;
//import java.util.List;
import java.util.NoSuchElementException;
//import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DevCommunityApp.App.entity.Developer;
import com.DevCommunityApp.App.entity.Feed;
//import com.DevCommunityApp.App.entity.User;
import com.DevCommunityApp.App.service.IFeedService;
/*import com.DevCommunityApp.App.entity.Response;
import com.DevCommunityApp.App.entity.Status;
import com.DevCommunityApp.App.entity.User;
import com.DevCommunityApp.App.repository.IFeedRepository;
import com.DevCommunityApp.App.repository.IUserRepository;
import com.DevCommunityApp.App.service.IDeveloperService;

import com.DevCommunityApp.App.service.IResponseService;
import com.DevCommunityApp.App.service.IUserService;*/
 


@RestController
@RequestMapping("/feed")
public class FeedController {

	@Autowired
	private IFeedService feedService;
	
	//POST Method to add feed
	@PostMapping("/add")
    public void add(@RequestBody Feed feed) {
		feedService.addFeed(feed);
    }
	//PUT method to update the feed
	 @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@RequestBody Feed feed, @PathVariable Integer id){
		 try {
			 feedService.editFeed(feed);
			 return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
		}
	 }
	 //GET method to get all feed
	 @GetMapping("/getfeeds")
	    public List<Feed> list() {
	        return feedService.listAllUser();
	    }
	//GET Method get feed
	 @GetMapping("/{id}")
	    public ResponseEntity<Feed> get(@PathVariable Integer id){
			try {
				Feed feed = feedService.getFeed(id);
	            return new ResponseEntity<Feed>(feed, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<Feed>(HttpStatus.NOT_FOUND);
	        }
		}
	 //DELETE method to delete feed
	 @DeleteMapping("/{id}")
		public void removeFeed(@PathVariable Integer id) {
			 feedService.removeFeed(id);
		}
//PUT Method to update like	 
	 @PutMapping("/likeupdate/{id}")
	    public ResponseEntity<Feed> feed(@RequestBody Integer id){
		 try {
			 feedService.likeFeed(id);
			 return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
			return new ResponseEntity<Feed>(HttpStatus.NOT_FOUND);
		}
	 }  
}
	 
	 
	 
	 
	 
	

	
	 
	 