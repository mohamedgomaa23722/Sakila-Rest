package com.iti.sakila.persistance.dao;

import com.iti.sakila.persistance.entity.Rental;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface RentalTransaction{
    public List<Rental> findRentalByInventory(int inventoryId, EntityManager entityManager);
}
