package com.iti.sakila.persistance.repository;

import com.iti.sakila.bussiness.exceptions.ExistException;
import com.iti.sakila.persistance.entity.City;
import jakarta.persistence.EntityManager;

public class CityRepository extends BaseRepository<City>{
    public CityRepository() {
        super(City.class);
    }


    @Override
    public City insert(City entity, EntityManager entityManager) {
        if (isExist(entity.getCity(), "city", entityManager).getCity().equals(entity.getCity()))
            throw new ExistException("city is exist before with id = " + entity.getCity());

        return super.insert(entity, entityManager);
    }
}
