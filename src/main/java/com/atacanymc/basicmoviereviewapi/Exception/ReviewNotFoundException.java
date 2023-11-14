package com.atacanymc.basicmoviereviewapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Review Not Found")
public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
