package com.iti.sakila.bussiness.exceptions.exceptionMapper;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.utils.ExceptionResponseBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InputDataExceptionMapper implements ExceptionMapper<InputDataException> {
    @Override
    public Response toResponse(InputDataException e) {
        return new ExceptionResponseBuilder()
                .setCode(500)
                .setMessage("Body Message doesn't contain required field")
                .setDescription(e.getMessage())
                .build();
}
}
