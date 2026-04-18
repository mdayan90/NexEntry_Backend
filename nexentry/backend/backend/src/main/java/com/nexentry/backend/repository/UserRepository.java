package com.nexentry.backend.repository;

import com.nexentry.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByPhone(String phone);
}