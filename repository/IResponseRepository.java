package com.demo.DevCom.repository;

//import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.DevCom.entity.Response;

public interface IResponseRepository extends JpaRepository<Response,Integer> {

	
}
