package com.bbd.modisa.data.service;
import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.User;
import com.bbd.modisa.data.model.AppData;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
public class BankingDataService implements AppData {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    @Transactional
    public User createUser(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();
        entityManager.close();
        return user;
    }

    @Transactional
    public Account createAccount(Account account){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(account);
        entityTransaction.commit();
        entityManager.close();
        return account;
    }
}
