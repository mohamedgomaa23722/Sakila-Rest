package com.iti.sakila.bussiness.exceptions;

public class InputDataException extends RuntimeException{
    public InputDataException(String message) {
        super(message);
    }
}
