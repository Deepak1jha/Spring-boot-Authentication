package com.eshop.Eshop.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class AppUtil {

    public static String generateRandomUniqueString() {
        return UUID.randomUUID().toString();
    }

    public static Map<String, String> errorFields(BindingResult result) {
        Map<String, String> fieldErrorMap = new HashMap<>();
        List<FieldError> fieldErrorList = result.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return fieldErrorMap;
    }

}
