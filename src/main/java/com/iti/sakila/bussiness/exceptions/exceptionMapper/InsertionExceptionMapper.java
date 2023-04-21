package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.exceptions.InsertionException;
import com.iti.sakila.utils.ExceptionResponseBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InsertionExceptionMapper implements ExceptionMapper<InsertionException> {
    @Override
    public Response toResponse(InsertionException e) {
        return new ExceptionResponseBuilder()
                .setCode(500)
                .setMessage("invalid Insertion Operation happens")
                .setDescription(e.getMessage())
                .build();
    }
}
