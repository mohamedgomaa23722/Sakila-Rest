package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.dao.BaseTransaction;
import com.iti.sakila.persistance.entity.Payment;
import com.iti.sakila.persistance.entity.Rental;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class TransactionRepository<T> extends BaseRepository<T> implements BaseTransaction {
    private final Class<T> src;

    public TransactionRepository(Class<T> src) {
        super(src);
        this.src = src;
    }

    @Override
    public List<T> findTransactionsForCustomer(int customerId, int page, EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
        Root<T> root = criteriaBuilderQuery.from(src);
        criteriaBuilderQuery.where(criteriaBuilder.equal(root.get("customer").<Short>get("customerId"), customerId));
        return entityManager.createQuery(criteriaBuilderQuery)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<T> findTransactionByDate(Date from, Date to, int page, EntityManager entityManager) {
        String dateFieldName = (src == Payment.class) ? "paymentDate" : "rentalDate";
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
        Root<T> root = criteriaBuilderQuery.from(src);
        criteriaBuilderQuery.where(criteriaBuilder.between(root.get(dateFieldName), from, to));
        return entityManager.createQuery(criteriaBuilderQuery)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<T> findTransactionsForStaff(int staffId, int page, EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
        Root<T> root = criteriaBuilderQuery.from(src);
        criteriaBuilderQuery.where(criteriaBuilder.equal(root.get("staff").<Integer>get("staffId"), staffId));
        return entityManager.createQuery(criteriaBuilderQuery)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }
}
