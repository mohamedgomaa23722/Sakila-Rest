package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.Message;

import java.util.List;

public interface ServiceInterface<T,R> {
    List<R> getAll(int page);
    Message insert(R object);
    Message update(R object, int id);
    Message delete(int id);
    R findById(int id);
    List<R> findByName(String name, String fieldName, int page);
    T isExist(String name, String fieldName);
}
