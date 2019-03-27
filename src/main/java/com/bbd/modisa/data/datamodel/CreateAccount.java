package com.bbd.modisa.data.datamodel;
import com.bbd.modisa.data.entities.Account;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
public class CreateAccount {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    public void createAcc(Account account){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        EntityTransaction entityTransaction =entityManager.getTransaction();
        entityTransaction.begin();

        Query query =  entityManager.createNativeQuery("INSERT INTO Account(availBalance, User_userId, accType)" +
                    " VALUES(?, ?, ?)");
        query.setParameter(1, account.getAvailBalance());
        query.setParameter(2, account.getUser_userId());
        query.setParameter(3, account.getAccType());

        entityManager.persist(account);
        query.executeUpdate();
        entityTransaction.commit();
        entityManager.close();
    }

    public void deposit(double balance, int accountId) {

        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("UPDATE Account SET availBalance = availBalance" +
                    "+ ? WHERE accId = ?");

        query.setParameter(1, balance);
        query.setParameter(2, accountId);
        query.executeUpdate();
        entityManager.close();
    }

    public void withdrawal(double balance, int accountId){

        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("UPDATE Account SET availBalance = availBalance" +
                " - ? WHERE accId = ?");

        query.setParameter(1, balance);
        query.setParameter(2, accountId);
        query.executeUpdate();
        entityManager.close();
    }
}
