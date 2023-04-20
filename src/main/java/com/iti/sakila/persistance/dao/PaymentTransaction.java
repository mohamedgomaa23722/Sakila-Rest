package com.iti.sakila.persistance.dao;

import com.iti.sakila.persistance.entity.Payment;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentTransaction  {
    public List<Payment> findByAmount(BigDecimal amount, int page, EntityManager entityManager);

    public List<Payment> findByRental(int rentalId, int page, EntityManager entityManager);


}
