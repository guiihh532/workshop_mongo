package com.gomlek.workshop_mongo.repository;

import com.gomlek.workshop_mongo.domain.Post;
import com.gomlek.workshop_mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
