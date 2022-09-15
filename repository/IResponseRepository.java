package com.DevCommunityApp.App.repository;

//import java.util.Collection;
//import java.util.List;

//import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.DevCommunityApp.App.entity.Feed;
import com.DevCommunityApp.App.entity.Response;

@Repository
public interface IResponseRepository extends JpaRepository<Response,Integer> {

}