package com.idol.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String  fieldValue;
    private String resourceName;
    private long fieldName;

    public ResourceNotFoundException(String fieldValue, String resourceName, long fieldName) {
        super(String.format("%s not found %s: '%s'",resourceName,fieldValue,fieldName));
        this.fieldValue = fieldValue;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public long getFieldName() {
        return fieldName;
    }
}
