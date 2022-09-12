package com.example.emp.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.emp.entity.User;
import com.example.emp.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/developerCommunity")
public class UserController {
	
    private final IUserService userService ;
    
    @Autowired
    public UserController(IUserService userService) {
		this.userService = userService;
	}

    @GetMapping
    public List<User> list() {
        return userService.listAllUser();
    }


	@PostMapping
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }
	
    @PutMapping("/{userid}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable String userid) {
        try {
            User existUser = userService.getUser(userid);
            user.setUserid(userid);            
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{userid}")
    public void delete(@PathVariable String userid) {

        userService.deleteUser(userid);
}
    
}
