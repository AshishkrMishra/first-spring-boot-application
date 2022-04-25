package com.akm.firstspringbootapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akm.firstspringbootapp.model.User;
import com.akm.firstspringbootapp.model.UserKey;

@Repository
public interface UserRepository extends MongoRepository<User, UserKey> {

}
