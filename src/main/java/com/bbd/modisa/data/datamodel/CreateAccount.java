package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.Account;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Transactional
public class CreateAccount {
    private Connection connection = ConnectionConfig.getConnection();
    private PreparedStatement preparedStatement = null;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = null;

    public void createAcc(Account account){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query =  entityManager.createNativeQuery("INSERT INTO Account(availBalance, User_userId, accType)" +
                    " VALUES(?, ?, ?)");
        query.setParameter(1, account.getAvailBalance());
        query.setParameter(2, account.getUserId());
        query.setParameter(3, account.getAccType());
        query.executeUpdate();
        entityManager.close();
    }

    public void deposit(double balance, int accountId) throws SQLException {

        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("UPDATE Account SET availBalance = availBalance" +
                    "+ ? WHERE accId = ?");

        query.setParameter(1, balance);
        query.setParameter(2, accountId);
        query.executeUpdate();
    }

    public void withdrawal(double balance, int accountId) throws SQLException {
            preparedStatement = connection.prepareStatement("UPDATE Account SET availBalance = availBalance" +
                    "- ? WHERE accId = ?");
            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
    }
}
