package com.iti.sakila.bussiness.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ExistException extends RuntimeException{
    public ExistException(String message) {
        super(message);
    }
}
