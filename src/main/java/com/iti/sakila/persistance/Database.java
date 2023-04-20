package com.iti.sakila.persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Database {
    private Database() {
    }

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sakila");

    public static <R> R doInTransaction( Function<EntityManager, R> returningTransactionFunction ) {
        System.out.println("*************** ------ open connection ------- ***************");
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            R result = returningTransactionFunction.apply(entityManager);
            transaction.commit();
            return result;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            System.out.println("*************** ------ close connection ------- ***************");
            entityManager.close();
        }
    }

    public static void doInTransactionWithoutResult(
            Consumer<EntityManager> voidTransactionFunction) {
        System.out.println("*************** ------ open connection ------- ***************");
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            voidTransactionFunction.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            System.out.println("*************** ------ close connection ------- ***************");
            entityManager.close();
        }
    }

    public static <T, P> List<T> doSingleParameterSelectQuery(String query, P parameter, Class<T> src, int page) {
        return Database.doInTransaction(entityManager -> entityManager.createQuery(query, src)
                .setParameter(1, parameter)
                .setFirstResult((page - 1 ) * 10)
                .setMaxResults(10)
                .getResultList());
    }

    public static void close() {
        emf.close();
        System.out.println("Database resources cleaned up");
    }
}