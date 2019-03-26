package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.entities.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GetUser {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    public User getId(int id){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT a.*, u.* FROM User u, Account a WHERE u.userId = ? " +
                "AND u.userId = a.User_userId");
        query.setParameter(1, id);

        User user = (User) query.getSingleResult();

        return user;
    }
}
