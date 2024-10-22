package com.csg.entity.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MonoFluxSerializationException extends RuntimeException {
    public MonoFluxSerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
