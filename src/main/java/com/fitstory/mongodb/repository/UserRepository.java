package com.fitstory.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitstory.mongodb.entity.Offers;
import com.fitstory.mongodb.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


//
}