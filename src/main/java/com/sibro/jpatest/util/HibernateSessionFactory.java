package com.sibro.jpatest.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class HibernateSessionFactory {
    @PersistenceUnit
    private static final EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("sibro");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}