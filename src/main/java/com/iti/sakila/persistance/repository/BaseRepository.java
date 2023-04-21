package com.iti.sakila.persistance.repository;

import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.bussiness.exceptions.InsertionException;
import com.iti.sakila.persistance.dao.BaseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class BaseRepository<T> implements BaseDao<T> {
    private final Class<T> src;

    public BaseRepository(Class<T> src) {
        this.src = src;
    }

    public List<T> getAll(int page, EntityManager entityManager) {
        return entityManager
                .createQuery("From " + src.getName(), src)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }

    public boolean update(T entity, int id, EntityManager entityManager) {
        if (findById(id, entityManager) != null) {
            try {
                entityManager.merge(entity);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Can't update entity id = " + id);
            }
        } else {
            throw new NotExistException("Can't found " + src.getName() + " with id = " + id);
        }
    }

    public boolean delete(int id, EntityManager entityManager) {

        T entity = findById(id, entityManager);
        System.out.println("---------------- ****** ENtity ******* ------------");
        System.out.println("entity id : " +id);
        System.out.println("Entity : "+entity);
        System.out.println("---------------------------------------------------");
            if (entity != null) {
                entityManager.remove(entity);
                System.out.println("contains entity");
            } else {
                return false;
            }
            return true;
    }

    public T findById(int id, EntityManager entityManager) {
            try {
                T entity = entityManager.find(src, id);
                System.out.println("---------------- ****** Find entity ******* ------------");
                System.out.println("entity id : " +id);
                System.out.println("Founded Entity : "+entity);
                System.out.println("---------------------------------------------------");
                return entity;
            } catch (Exception ex) {
                throw new NotExistException(src.getSimpleName() + " id is not exist into our database");
            }
    }

    @Override
    public T insert(T entity, EntityManager entityManager) {
        try {
            return  entityManager.merge(entity);
        } catch (Exception e) {
            throw new InsertionException("fail to Insert object with values ('" + entity + "') due to : " + e.getMessage());
        }
    }

    @Override
    public T isExist(String name, String fieldName, EntityManager entityManager) {
            try {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
                Root<T> root = criteriaBuilderQuery.from(src);
                criteriaBuilderQuery.where(criteriaBuilder.equal(root.get(fieldName), name));
                return entityManager.createQuery(criteriaBuilderQuery)
                        .getSingleResult();
            } catch (Exception ex) {
                return null;
            }
    }

    @Override
    public List<T> findByName(String name, String fieldName, int page, EntityManager entityManager) {
            try {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
                Root<T> root = criteriaBuilderQuery.from(src);
                criteriaBuilderQuery.where(criteriaBuilder.like(root.get(fieldName), name + "%"));
                return entityManager.createQuery(criteriaBuilderQuery)
                        .getResultList();
            } catch (Exception ex) {
                throw new NotExistException("There are no results with name \"" + name + "\" into our database");
            }
    }
}
