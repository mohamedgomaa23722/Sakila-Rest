package com.iti.sakila.persistance.dao;

import com.iti.sakila.persistance.entity.Film;

import java.math.BigDecimal;
import java.util.List;

public interface FilmDao {
    List<Film> findByCategoryId(int categoryId, int page);

    List<Film> findByRate(BigDecimal rating, int page);

    List<Film> findByCost(BigDecimal price, int page);
}
