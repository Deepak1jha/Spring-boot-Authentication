package com.eshop.Eshop.model.security;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class UserRole {

    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

}
