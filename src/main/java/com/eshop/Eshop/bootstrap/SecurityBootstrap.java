package com.eshop.Eshop.bootstrap;

import com.eshop.Eshop.model.admin.Admin;
import com.eshop.Eshop.model.security.Role;
import com.eshop.Eshop.model.security.UserRole;
import com.eshop.Eshop.repository.security.AdminRepository;
import com.eshop.Eshop.repository.security.RoleRepository;
import com.eshop.Eshop.repository.security.UserRoleRepository;
import com.eshop.Eshop.util.constant.SecurityConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SecurityBootstrap {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createData() {
        createRole();
        createSuperAdmin();
    }

    private void createRole() {
        List<String> roleList = Arrays.asList(SecurityConstant.ROLE_ADMIN, SecurityConstant.ROLE_EMPLOYEE, SecurityConstant.ROLE_INTERN);
        for (String roleName : roleList) {
            if (roleRepository.countByName(roleName) == 0) {
                roleRepository.save(new Role(roleName));
            }
        }
    }

    private void createSuperAdmin() {
        List<String> adminEmailAddressList = Arrays.asList("Admin@1", "Admin@2");
        for (String emailAddress : adminEmailAddressList) {
            if (!adminRepository.existsByUsername(emailAddress)) {
                Admin superAdmin = new Admin();
                superAdmin.setUsername(emailAddress);
                superAdmin.setPassword(passwordEncoder.encode("123"));
                if (emailAddress.equals(adminEmailAddressList.get(0))) {
                    superAdmin.setFirstName("User");
                    superAdmin.setLastName("One");
                } else if (emailAddress.equals(adminEmailAddressList.get(1))) {
                    superAdmin.setFirstName("User");
                    superAdmin.setLastName("Two");
                }
                superAdmin.setEnabled(Boolean.TRUE);
                adminRepository.save(superAdmin);
                UserRole userRole = new UserRole(superAdmin, roleRepository.findByName(SecurityConstant.ROLE_ADMIN).get());
                userRoleRepository.save(userRole);
            }
        }
    }
}
