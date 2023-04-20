package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.entity.Store;

import java.util.List;

public class StoreRepository extends BaseRepository<Store>{
    public StoreRepository() {
        super(Store.class);
    }

}
