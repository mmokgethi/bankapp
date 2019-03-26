package com.bbd.modisa.data.datamodel;


import com.bbd.modisa.model.Transactions;

import javax.persistence.*;
import javax.transaction.Transactional;


public class CreateTran  {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    @Transactional
    public void   createTran(Transactions transactions){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("INSERT INTO Transaction(amount, tranType, Account_accId, " +
                "Account_User_userId) VALUES(?, ? , ?, ?)");

        query.setParameter(1, transactions.getAmount());
        query.setParameter(2, transactions.getTransactionType());
        query.setParameter(3, transactions.getAccId());
        query.setParameter(4, transactions.getUserId());

        entityManager.persist(transactions);

        query.executeUpdate();
        entityTransaction.commit();
        entityManager.close();
    }
}
