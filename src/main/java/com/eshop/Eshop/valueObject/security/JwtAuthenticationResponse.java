package com.eshop.Eshop.valueObject.security;

import lombok.Data;

import java.util.List;
@Data
public class JwtAuthenticationResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private List<String> roleList;
    private String uniqueId;

    public JwtAuthenticationResponse(String accessToken, List<String> roleList, String uniqueId) {
        this.roleList = roleList;
        this.accessToken = accessToken;
        this.uniqueId = uniqueId;
    }

}
