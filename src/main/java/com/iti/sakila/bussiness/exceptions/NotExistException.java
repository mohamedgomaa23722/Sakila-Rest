package com.iti.sakila.bussiness.exceptions;

public class NotExistException extends RuntimeException{
    public NotExistException(String message) {
        super(message);
    }
}
