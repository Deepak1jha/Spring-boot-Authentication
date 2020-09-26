package com.eshop.Eshop.repository.security;

import com.eshop.Eshop.model.admin.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AdminRepository extends MongoRepository<Admin, String> {

    Boolean existsByUsername(String emailAddress);

}
