package com.iti.sakila.bussiness.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class InputDataValidator {
    private static StringBuilder message;

    public static <T> boolean isValidData(T object) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> constraintViolationsValid = validator.validate(object);
        if (constraintViolationsValid.size() > 0) {
            message = new StringBuilder();
            for (ConstraintViolation<T> tConstraintViolation : constraintViolationsValid) {
                message.append(tConstraintViolation.getMessage()).append(" And ");
            }
            return false;
        } else {
            return true;
        }
    }

    public static StringBuilder validateMessage() {
        return message;
    }
}
