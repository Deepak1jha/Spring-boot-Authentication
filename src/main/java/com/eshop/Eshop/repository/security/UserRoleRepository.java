package com.eshop.Eshop.repository.security;

import com.eshop.Eshop.model.security.Role;
import com.eshop.Eshop.model.security.User;
import com.eshop.Eshop.model.security.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRoleRepository extends MongoRepository<UserRole, String> {

    Iterable<UserRole> findAllByUser(User user);

    Iterable<UserRole> findAllByRole(Role role);

}