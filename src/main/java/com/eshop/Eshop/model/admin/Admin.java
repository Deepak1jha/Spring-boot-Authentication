package com.eshop.Eshop.model.admin;


import com.eshop.Eshop.model.security.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "users")
@TypeAlias("admin")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Admin extends User implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

}
