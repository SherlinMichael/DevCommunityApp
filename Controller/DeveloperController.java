package com.DevCommunityApp.App.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevCommunityApp.App.entity.Developer;
import com.DevCommunityApp.App.service.IDeveloperService;


@RestController
@RequestMapping("/developer")
public class DeveloperController {

	@Autowired
	private IDeveloperService developerService;
	
//GET method to get all Developer
	@GetMapping("")
    public List<Developer> list() {
        return developerService.getAllDevelopers();
    }
	
//GET method to get all Developer
	@GetMapping("/{id}")
    public ResponseEntity<Developer> get(@PathVariable Integer id){
		try {
			Developer dev = developerService.getDeveloper(id);
            return new ResponseEntity<Developer>(dev, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
        }
	}
	
//POST method to Add Developer
	 @PostMapping("/add")
	    public void add(@RequestBody Developer dev) {
	        developerService.addDeveloper(dev);
	    }
	 
//PUT method to update Developer Status
	 @PutMapping("/statusupdate/{id}")
	    public ResponseEntity<?> updateStatus(@RequestBody Developer dev,@PathVariable Integer id){
		 try {
			 developerService.statusUpdate(dev);
			 return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
		}
	 }
	 
//PUT method to update Developer Status by Id 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@RequestBody Developer dev, @PathVariable Integer id){
		 try {
			 developerService.editDeveloper(dev);
			 return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Developer>(HttpStatus.NOT_FOUND);
		}
	 }
	 
	 
	 
	 
}