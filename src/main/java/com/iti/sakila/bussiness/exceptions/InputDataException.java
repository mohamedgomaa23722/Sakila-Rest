package com.iti.sakila.bussiness.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

public class InputDataException extends RuntimeException {
    public InputDataException(String message) {
        super(message);
    }
}
