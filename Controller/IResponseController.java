package com.DevCommunityApp.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DevCommunityApp.App.entity.Feed;
import com.DevCommunityApp.App.entity.Response;
import com.DevCommunityApp.App.service.IFeedService;
import com.DevCommunityApp.App.service.IResponseService;

@RestController
public class IResponseController {

	@Autowired
	private IResponseService iresponseService;
	@Autowired
	private IFeedService feedService;

//GET method to get all response
	// @RequestMapping(method = RequestMethod.GET,value="/responses")
	@GetMapping("/demoResponse")
	public List<Response> getResponse() {
		return iresponseService.findAllResponse();
	}

	  @RequestMapping(method = RequestMethod.POST,value="/add") 
	  public List<Response> addResp(@RequestBody Response resp, Feed feed) 
	  { 
		Feed addedFeed = feedService.findById1(feed.getFeedId()); 
	    resp.setFeed(addedFeed);
	    iresponseService.save(resp); 
	    return iresponseService.findAllresp();
	  
	  } 


//POST method to add response
	@RequestMapping(method = RequestMethod.POST, value = "/addResponse")
	public void addResponse(@RequestBody Response resp) {
		iresponseService.addResponse(resp);
	}

//PUT method to edit/update the response
	@RequestMapping(method = RequestMethod.PUT, value = "/demoResponse/{respId}")
	public void updateResponse(@PathVariable int respId, @RequestBody Response resp) {
		iresponseService.updateResponse(respId, resp);
	}

//DELETE method to delete Response
	@RequestMapping(method = RequestMethod.DELETE, value = "/demoResponse/{respId}")
	public void DeleteResponse(@PathVariable int respId, @RequestBody Response resp) {
		iresponseService.deleteResponse(respId);
	}
	
}