package com.ecom.starter.repositories;

import com.ecom.starter.model.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserTable extends MongoRepository<UserData, String> {
    public UserData findByUsername(String username);
    public void deleteByUsername(String username);

}