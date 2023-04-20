package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.exceptions.NotExistException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class InputDataExceptionMapper implements ExceptionMapper<InputDataException> {
    @Override
    public Response toResponse(InputDataException e) {
        return Response.status(500).entity(e.getMessage()).build();
    }
}
