package com.eshop.Eshop.repository.security;

import com.eshop.Eshop.model.security.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(String name);

    Integer countByName(String name);

}
