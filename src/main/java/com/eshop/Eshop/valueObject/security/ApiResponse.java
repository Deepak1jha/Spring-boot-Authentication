package com.eshop.Eshop.valueObject.security;

import com.eshop.Eshop.enums.Enums;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
 class ApiResponseVO implements Serializable {

    private Enums.ResponseType responseType;
    private String message;
    private Object data;


    public ApiResponseVO(Enums.ResponseType responseType, String message, Object data) {
        this.responseType = responseType;
        this.message = message;
        this.data = data;
    }

}
