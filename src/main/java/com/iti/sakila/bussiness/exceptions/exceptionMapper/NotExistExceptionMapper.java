package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.exceptions.NotExistException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class NotExistExceptionMapper implements ExceptionMapper<NotExistException> {
    @Override
    public Response toResponse(NotExistException e) {
        return Response.status(500).entity(e.getMessage()).build();
    }
}
