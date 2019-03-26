package com.bbd.modisa.data.datamodel;
import com.bbd.modisa.data.entities.User;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
public class CreateUser implements AppData {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    @Transactional
    public void createUser(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("INSERT INTO User(fName, lName)" +
                    "VALUES(?,?)");
        query.setParameter(1, user.getfName());
        query.setParameter(2, user.getlName());

        entityManager.persist(user);
        query.executeUpdate();
        entityTransaction.commit();
        entityManager.close();
    }

    @Transactional
    public Integer showId(){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT MAX(u.userId) FROM User u");

        Integer userId = (Integer) query.getSingleResult();
        entityManager.close();
        return userId;
    }

    @Transactional
    public int getAccId(int userId){
        int user_id;
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT DISTINCT(a.accId) FROM Account a, User u " +
                "WHERE a.User_userId = ?");
        query.setParameter(1, userId);
        user_id = (int)query.getSingleResult();
        entityManager.close();
        return user_id;
    }
}
