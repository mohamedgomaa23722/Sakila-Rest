package com.iti.sakila.bussiness.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Message {
    private  int code;
    private  String message;
    private  String messageDesc;

    private Object object;
}
