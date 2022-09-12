package com.demo.DevCom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DevCom.entity.Response;
import com.demo.DevCom.service.IResponseService;

@RestController
public class IResponseController {

	@Autowired
	private IResponseService iresponseService;
	
	//@RequestMapping(method = RequestMethod.GET,value="/responses")
	@GetMapping("/demoResponse")
	public List<Response> getResponse(){
		return  iresponseService.getAllResponse();
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/demoResponse")
	public void addResponse(@RequestBody Response resp) {
		 iresponseService.addResponse(resp);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/demoResponse/{respId}")
	public void updateResponse(@PathVariable int respId,@RequestBody Response resp) {	
		 iresponseService.updateResponse(respId,resp);
	}
	@RequestMapping(method = RequestMethod.DELETE,value="/demoResponse/{respId}")
	public void DeleteResponse(@PathVariable int respId,@RequestBody Response resp) {
		 iresponseService.deleteResponse(respId);
	}

}
