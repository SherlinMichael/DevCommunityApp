package com.example.emp.repository;


import java.util.Optional;

import com.example.emp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {

	}
