package com.DevCommunityApp.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevCommunityApp.App.entity.Feed;
@Repository
public interface IFeedRepository extends JpaRepository<Feed, Long>{

}
