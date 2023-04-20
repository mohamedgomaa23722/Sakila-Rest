package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.dao.BaseTransaction;
import com.iti.sakila.persistance.repository.TransactionRepository;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class BaseTransactionService<T, R> extends BaseService<T, R> {
    private Class<T> src;
    protected TransactionRepository<T> baseTransaction;

    protected BaseMapper<T, R> baseMapper;

    public BaseTransactionService(Class<T> src, BaseMapper<T, R> baseMapper) {
        super(src, baseMapper);
        this.src = src;
        this.baseTransaction = new TransactionRepository<>(src);
        this.baseMapper = baseMapper;
    }

    public List<R> findTransactionsForCustomer(int customerId, int page) {
        return Database.doInTransaction(entityManager -> {
            List<T> transactions = baseTransaction.findTransactionsForCustomer(customerId, page, entityManager);
            return baseMapper.toDtoList(transactions);
        });

    }

    public List<R> findTransactionByDate(Date from, Date to, int page) {
        return Database.doInTransaction(entityManager -> {
            List<T> transactions = baseTransaction.findTransactionByDate(from, to, page, entityManager);
            return baseMapper.toDtoList(transactions);
        });
    }

    public List<R> findTransactionsForStaff(int staffId, int page) {
        return Database.doInTransaction(entityManager ->{
             List<T> transactions =baseTransaction.findTransactionsForStaff(staffId, page, entityManager);
             return baseMapper.toDtoList(transactions);
         });
    }
}
