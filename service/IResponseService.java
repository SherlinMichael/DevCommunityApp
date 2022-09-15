package com.DevCommunityApp.App.service;

//import java.util.ArrayList;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.DevCommunityApp.App.entity.Feed;
import com.DevCommunityApp.App.entity.Response;
//import com.DevCommunityApp.App.repository.IFeedRepository;
import com.DevCommunityApp.App.repository.IResponseRepository;

@Service
public class IResponseService {

	
	@Autowired
    public IResponseRepository iresponseRepository;
	//@Autowired
	//private IFeedRepository feedRepository;
	
//Method to Get All Response
	public List<Response> findAllResponse()
	{
		return iresponseRepository.findAll();
		
	}
//Method to	Add Response
	//@Transactional
	public void addResponse(Response resp)
	{
		iresponseRepository.save(resp);
		
	}
//Method to	Edit/Update Response
	public void updateResponse(int respId,Response resp) 
	{
		iresponseRepository.save(resp);	
	}
//Method to Delete Response
	public void deleteResponse(int respId) 
	{
		iresponseRepository.deleteById(respId);	
	}
	public void save(Response resp) {
		iresponseRepository.save(resp);
		
	}
	public List<Response> findAllresp() {
		
		return iresponseRepository.findAll();
	}
}