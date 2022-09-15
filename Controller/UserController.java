package com.DevCommunityApp.App.controller;

import java.util.List;
//import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.DevCommunityApp.App.entity.User;
import com.DevCommunityApp.App.entity.Status;
import com.DevCommunityApp.App.repository.IUserRepository;
import com.DevCommunityApp.App.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
    IUserRepository userRepository;  
	
    private final IUserService userService ;
    
    @Autowired
    public UserController(IUserService userService) {
		this.userService = userService;
	}
    //GET Method to get ListOFUsers
	 @GetMapping("/developerCommunity")
	    public List<User> list() {
	        return userService.listAllUser();
	    }
	//POST Method For User Registration
	@PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userService.listAllUser();        
        System.out.println("New user: " + newUser.toString());        
        for (User user : users) {
             System.out.println("Registered user: " + newUser.toString());            
		if (user.equals(newUser)) {
             System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
             
        }        userService.saveUser(newUser);
        
        return Status.SUCCESS;
    }   
	//POST Method For User LOGIN
	@PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = userService.listAllUser();        
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userService.saveUser(user);
                return Status.SUCCESS;
            }
        }        return Status.FAILURE;
    }    
	//POST Method For User LOGOUT
	@PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userService.listAllUser();       
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userService.saveUser(user);
                return Status.SUCCESS;
            }
        }        return Status.FAILURE;
    }    
    
	//Delete Method For Delete Specific User
	@DeleteMapping("/{userid}")
    public Status delete(@PathVariable String userid) {

        userService.deleteUser(userid);
        return Status.SUCCESS;
    }
	//Delete Method For Delete All User
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userService.deleteAll();
        return Status.SUCCESS;
    }
    
}