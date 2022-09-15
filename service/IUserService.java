package com.DevCommunityApp.App.service;


import java.util.List;

import com.DevCommunityApp.App.entity.User;
import com.DevCommunityApp.App.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
@Service

public class IUserService {

	@Autowired
    private IUserRepository userRepository;
	
	//Method to FindAll
    public List<User> listAllUser() {
        return (List<User>) userRepository.findAll();
    }
  //Method to Save User
    public void saveUser(User user) {
        userRepository.save(user);
    }
  //Method to Find the User by Id
    public User getUser(String id) {
        return userRepository.findById(id).get();
    }
  //Method to Delete the User by Id
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
  //Method to Delete All User
    public void deleteAll() {
        userRepository.deleteAll();
    }
}