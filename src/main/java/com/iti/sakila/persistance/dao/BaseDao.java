package com.iti.sakila.persistance.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

public interface BaseDao<T> {
    List<T> getAll(int page, EntityManager entityManager);
    boolean update(T entity, int id, EntityManager entityManager);
    boolean delete(int id, EntityManager entityManager);
    T findById(int id, EntityManager entityManager);
    T insert(T entity, EntityManager entityManager);
    T isExist(String name,String fieldName, EntityManager entityManager);
    List<T> findByName(String name, String fieldName, int page, EntityManager entityManager);
}
