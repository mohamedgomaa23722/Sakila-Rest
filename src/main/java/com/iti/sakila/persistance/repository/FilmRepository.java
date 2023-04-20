package com.iti.sakila.persistance.repository;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.dao.FilmDao;
import com.iti.sakila.utils.FilterRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FilmRepository extends BaseRepository<Film> implements FilmDao {

    public FilmRepository() {
        super(Film.class);
    }

    public List<Film> findByCategoryId(int categoryId, int page) {
        String query = "Select f From Film f, FilmCategory fc where f.filmId = fc.id.filmId And fc.id.categoryId = ?1";
        return Database.doSingleParameterSelectQuery(query, categoryId, Film.class, page);
    }

    @Override
    public List<Film> findByRate(BigDecimal rating, int page) {
        String query = "From Film f where f.rentalRate >= ?1";
        return Database.doSingleParameterSelectQuery(query, rating, Film.class, page);
    }

    @Override
    public List<Film> findByCost(BigDecimal price, int page) {
        String query = "From Film f where f.replacementCost >= ?1";
        return Database.doSingleParameterSelectQuery(query, price, Film.class, page);
    }

    public boolean delete(int id, EntityManager entityManager) {
        return true;
    }

    public List<Film> findFilmWithMultipleFilters(FilterRecord filterRecord, EntityManager entityManager) {
          CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
          CriteriaQuery<Film> criteriaBuilderQuery = criteriaBuilder.createQuery(Film.class);
          Root<Film> filmRoot = criteriaBuilderQuery.from(Film.class);
          //Create List of predicates
          List<Predicate> predicates = new ArrayList<>();

          // 1 - RequestFilter by name
          predicates.add(criteriaBuilder.like(filmRoot.get("title"), filterRecord.getName() + "%"));

          // 2 - RequestFilter by category

          // 3 - RequestFilter by price
          if (!filterRecord.getPrice().equals("0"))
              predicates.add(criteriaBuilder.greaterThanOrEqualTo(filmRoot.get("replacementCost"), filterRecord.getPrice()));

          // 4 - RequestFilter by rate
          if (!filterRecord.getRate().equals("0"))
              predicates.add(criteriaBuilder.greaterThanOrEqualTo(filmRoot.get("rentalRate"), filterRecord.getRate()));

          //And then return only 10 films per request
          Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
          criteriaBuilderQuery.select(filmRoot).where(finalPredicate);

          //return film list
          return entityManager.createQuery(criteriaBuilderQuery)
                  .setFirstResult( (filterRecord.getPage() - 1 ) * 10)  // offset
                  .setMaxResults(10) // limit
                  .getResultList();
    }
}
