package com.example.capstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicateDescriptionException extends RuntimeException {
    public DuplicateDescriptionException(String message) {
        super(message);
    }
}
