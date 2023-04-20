package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.dao.RentalTransaction;
import com.iti.sakila.persistance.entity.Rental;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RentalRepository extends TransactionRepository<Rental> implements RentalTransaction {
    public RentalRepository() {
        super(Rental.class);
    }

    @Override
    public List<Rental> findRentalByInventory(int inventoryId, EntityManager entityManager) {
        String query = "From Rental r where r.inventory.inventoryId = ?1";
        return entityManager.createQuery(query, Rental.class)
                .setParameter(1, inventoryId)
                .getResultList();
    }
}