package com.demo.DevCom.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.DevCom.entity.Response;
import com.demo.DevCom.repository.IResponseRepository;

@Service
public class IResponseService {

	
	@Autowired
    public IResponseRepository iresponseRepository;
	
	public List<Response> getAllResponse()
	{
		List<Response> responses = new ArrayList<Response>();
		iresponseRepository.findAll().forEach(responses::add);
		return responses;
	}
	public void addResponse(Response resp)
	{
		iresponseRepository.save(resp);
		
	}
	public void updateResponse(int respId,Response resp) 
	{
		iresponseRepository.save(resp);	
	}
	public void deleteResponse(int respId) 
	{
		iresponseRepository.deleteById(respId);	
	}
    
}
