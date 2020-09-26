package com.eshop.Eshop.repository.security;

import com.eshop.Eshop.model.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByPhoneNumberOrUsername(String phoneNumber, String emailAddress);

    Optional<User> findByUniqueId(String uniqueId);

}
