package com.iti.sakila.bussiness.exceptions;

public class UpdateException extends RuntimeException{
    public UpdateException(String message) {
        super(message);
    }
}
