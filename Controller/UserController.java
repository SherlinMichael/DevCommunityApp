package com.example.emp.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.example.emp.entity.User;
import com.example.emp.entity.status;
import com.example.emp.repository.UserRepository;
import com.example.emp.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
    UserRepository userRepository;  
	
    private final IUserService userService ;
    
    @Autowired
    public UserController(IUserService userService) {
		this.userService = userService;
	}
    
	 @GetMapping("/developerCommunity")
	    public List<User> list() {
	        return userService.listAllUser();
	    }
	
	@PostMapping("/users/register")
    public status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userService.listAllUser();        
        System.out.println("New user: " + newUser.toString());        
        for (User user : users) {
             System.out.println("Registered user: " + newUser.toString());            
		if (user.equals(newUser)) {
             System.out.println("User Already exists!");
                return status.USER_ALREADY_EXISTS;
            }
             
        }        userService.saveUser(newUser);
        
        return status.SUCCESS;
    }   
	
	@PostMapping("/users/login")
    public status loginUser(@Valid @RequestBody User user) {
        List<User> users = userService.listAllUser();        
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userService.saveUser(user);
                return status.SUCCESS;
            }
        }        return status.FAILURE;
    }    
	
	@PostMapping("/users/logout")
    public status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userService.listAllUser();       
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userService.saveUser(user);
                return status.SUCCESS;
            }
        }        return status.FAILURE;
    }    
    
	
	@DeleteMapping("/{userid}")
    public status delete(@PathVariable String userid) {

        userService.deleteUser(userid);
        return status.SUCCESS;
    }
	
    @DeleteMapping("/users/all")
    public status deleteUsers() {
        userService.deleteAll();
        return status.SUCCESS;
    }
    
}
