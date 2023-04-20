package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Customer;
import com.iti.sakila.persistance.entity.Payment;

import java.util.List;

public class CustomerRepository extends BaseRepository<Customer> {

    public CustomerRepository(Class<Customer> src) {
        super(src);
    }


}
