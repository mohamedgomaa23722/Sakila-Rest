package com.iti.sakila.utils;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.MessageBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ExceptionResponseBuilder {

    private String message = "messsage";

    private String description = "desc";

    private int code;


    public ExceptionResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ExceptionResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ExceptionResponseBuilder setCode(int code) {
        this.code = code;
        return this;
    }

    public Response build(){
        Message exeptionMessage = new MessageBuilder(code)
                .setMessage(message)
                .setDescription(description)
                .build();
        return Response
                .status(code)
                .type(MediaType.APPLICATION_JSON)
                .entity(exeptionMessage)
                .build();
    }
}
