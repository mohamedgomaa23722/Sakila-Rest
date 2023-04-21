package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.exceptions.UpdateException;
import com.iti.sakila.utils.ExceptionResponseBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UpdateExceptionMapper implements ExceptionMapper<UpdateException> {
    @Override
    public Response toResponse(UpdateException e) {
        return new ExceptionResponseBuilder()
                .setCode(500)
                .setMessage("invalid Update Operation happens")
                .setDescription(e.getMessage())
                .build();
    }
}
