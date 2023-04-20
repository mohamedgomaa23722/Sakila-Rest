package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.dao.PaymentTransaction;
import com.iti.sakila.persistance.entity.Payment;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PaymentRepository extends TransactionRepository<Payment> implements PaymentTransaction {
    public PaymentRepository() {
        super(Payment.class);
    }


    @Override
    public List<Payment> findByAmount(BigDecimal amount, int page, EntityManager entityManager) {
        String query = "From Payment p where p.amount >= ?1";
        return entityManager.createQuery(query, Payment.class)
                .setParameter(1, amount)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<Payment> findByRental(int rentalId, int page, EntityManager entityManager) {
        String query = "From Payment p where p.rental.rentalId = ?1";
        return entityManager.createQuery(query, Payment.class)
                .setParameter(1, rentalId)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }
}
