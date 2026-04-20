package com.example.NexEntryBackend.repository;



import com.example.NexEntryBackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByPhone(String phone);
}