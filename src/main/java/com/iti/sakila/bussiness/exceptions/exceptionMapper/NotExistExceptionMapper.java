package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.utils.ExceptionResponseBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotExistExceptionMapper implements ExceptionMapper<NotExistException> {
    @Override
    public Response toResponse(NotExistException e) {
        return new ExceptionResponseBuilder()
                .setCode(500)
                .setMessage("Not existing object")
                .setDescription(e.getMessage())
                .build();
    }
}
