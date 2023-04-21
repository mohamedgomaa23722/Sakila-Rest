package com.iti.sakila.bussiness.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class NotExistException extends RuntimeException {
    public NotExistException(String message) {
        super(message);
    }
}
