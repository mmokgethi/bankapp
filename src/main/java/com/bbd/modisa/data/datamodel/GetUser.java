package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUser {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    public User getId(int id) throws SQLException {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT a.*, u.* FROM User u, Account a WHERE u.userId = ? " +
                "AND u.userId = a.User_userId");
        query.setParameter(1, id);

        User user = (User) query.getSingleResult();





        /*User user = new User();
        Account data = new Account();
        ResultSet resultSet = null;


        connection = ConnectionConfig.getConnection();
        String findUser = "SELECT a.*, u.* " +
                "FROM User u, Account a WHERE u.userId = ? AND u.userId = a.User_userId";
        preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            User.setAccId(resultSet.getInt("accId"));
            User.setAvailBalance(resultSet.getDouble("availBalance"));
            User.setAccType(resultSet.getString("accType"));
            user.setUserId(resultSet.getInt("userId"));
            user.setfName(resultSet.getString("fName"));
            user.setlName(resultSet.getString("lName"));*/

        return user;
    }
}
