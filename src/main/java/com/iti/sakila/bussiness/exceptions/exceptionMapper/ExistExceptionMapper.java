package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.exceptions.ExistException;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.utils.ExceptionResponseBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExistExceptionMapper implements ExceptionMapper<ExistException> {
    @Override
    public Response toResponse(ExistException e) {
        return new ExceptionResponseBuilder()
                .setCode(500)
                .setMessage("You Can't insert an existing object")
                .setDescription(e.getMessage())
                .build();
    }
}
