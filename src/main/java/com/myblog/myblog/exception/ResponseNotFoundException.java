package com.myblog.myblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.Format;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseNotFoundException extends RuntimeException{


    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResponseNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s Not found with %s: '%s' ", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
