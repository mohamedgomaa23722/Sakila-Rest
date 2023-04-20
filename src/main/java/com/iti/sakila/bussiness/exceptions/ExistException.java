package com.iti.sakila.bussiness.exceptions;

public class ExistException extends RuntimeException{
    public ExistException(String message) {
        super(message);
    }
}
