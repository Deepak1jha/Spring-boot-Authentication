package com.eshop.Eshop.model.security;

import com.eshop.Eshop.enums.Enums;
import com.eshop.Eshop.repository.security.UserRoleRepository;
import com.eshop.Eshop.service.BeanUtilService;
import com.eshop.Eshop.util.AppUtil;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "users")
@Data
public abstract class User {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
//    @Email(message = "Please Provide Your Email Address")
    private String username;
    @Indexed(sparse = true, direction = IndexDirection.DESCENDING)
    private String phoneNumber;
    private String password;
    private boolean enabled;
    private Enums.Status status = Enums.Status.CURRENT;
    private String uniqueId = AppUtil.generateRandomUniqueString();
    @CreatedDate
    private LocalDateTime dateCreated;
    @LastModifiedDate
    private LocalDateTime lastUpdated;
    private LocalDateTime currentDate;

    public List<Role> getRoles() {
        UserRoleRepository userRoleRepository = BeanUtilService.getBean(UserRoleRepository.class);
        Iterable<UserRole> userRoleIterable = userRoleRepository.findAllByUser(this);
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleIterable.forEach(userRoleList::add);
        return userRoleList.stream().map(UserRole::getRole).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Enums.Status getStatus() {
        return status;
    }

    public void setStatus(Enums.Status status) {
        this.status = status;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDateTime currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", status=" + status +
                ", uniqueId='" + uniqueId + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", currentDate=" + currentDate +
                '}';
    }
}
