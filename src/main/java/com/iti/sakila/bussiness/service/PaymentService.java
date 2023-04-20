package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.bussiness.mapper.PaymentMapper;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Payment;
import com.iti.sakila.persistance.repository.PaymentRepository;
import com.iti.sakila.persistance.repository.RentalRepository;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PaymentService extends BaseTransactionService<Payment, PaymentDto> {
    private final PaymentRepository rentalRepository = new PaymentRepository();

    public PaymentService() {
        super(Payment.class, PaymentMapper.INSTANCE);
    }

    public List<PaymentDto> findByAmount(BigDecimal amount, int page) {
        return Database.doInTransaction(entityManager -> PaymentMapper.INSTANCE.toDtoList(rentalRepository.
                findByAmount(amount, page, entityManager)));
    }

    public List<PaymentDto> findByRental(int rentalId, int page) {
        return Database.doInTransaction(entityManager -> PaymentMapper.INSTANCE.toDtoList(rentalRepository.
                findByRental(rentalId, page, entityManager)));
    }
}
