package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.data.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;



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

        entityManager.find(User.class, id);

        return user;
    }

    public List<Transaction> findAll(){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        entityManager.getTransaction().begin();
        return entityManager.createQuery("SELECT t FROM Transaction t", Transaction.class).getResultList();
    }


    public void listAll(){
        List<Transaction> transactions = findAll();
        for (Transaction transaction: transactions){
            System.out.println(transaction);
        }
    }

    public Transaction findById(int id){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        Transaction transaction = entityManager.find(Transaction.class, id);

        return transaction;
    }
}
