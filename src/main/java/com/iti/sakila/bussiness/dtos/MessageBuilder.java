package com.iti.sakila.bussiness.dtos;

public class MessageBuilder {
    private String failMessage;
    private String successfullyMessage;
    private String failMessageDesc;
    private String successfullyMessageDesc;
    private boolean isSuccessfully;

    private Object object;

    public MessageBuilder setFailMessage(String failMessage) {
        this.failMessage = failMessage;
        return this;
    }

    public MessageBuilder setSuccessfullyMessage(String successfullyMessage) {
        this.successfullyMessage = successfullyMessage;
        return this;
    }

    public MessageBuilder setFailMessageDesc(String failMessageDesc) {
        this.failMessageDesc = failMessageDesc;
        return this;
    }

    public MessageBuilder setSuccessfullyMessageDesc(String successfullyMessageDesc) {
        this.successfullyMessageDesc = successfullyMessageDesc;
        return this;
    }

    public MessageBuilder setSuccessfully(boolean successfully) {
        isSuccessfully = successfully;
        return this;
    }

    public MessageBuilder setObject(Object object) {
        this.object = object;
        return this;
    }

    public Message build() {
        if (isSuccessfully)
            return new Message(200, successfullyMessage, successfullyMessageDesc, object);
        return new Message(500, failMessage, failMessageDesc,object);
    }
}
