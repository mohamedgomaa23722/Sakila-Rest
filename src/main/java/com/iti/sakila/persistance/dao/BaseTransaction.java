package com.iti.sakila.persistance.dao;

import com.iti.sakila.persistance.entity.Rental;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface BaseTransaction<T> {
    List<T> findTransactionsForCustomer(int customerId, int page, EntityManager entityManager);

    List<T> findTransactionByDate(Date from, Date to, int page, EntityManager entityManager);

    List<T> findTransactionsForStaff(int staffId, int page, EntityManager entityManager);
}
