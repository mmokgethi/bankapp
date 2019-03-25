package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.User;
import com.bbd.modisa.model.AccountType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUser {
    public User getId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        User user = new User();
        Account dataA = new Account();
        ResultSet resultSet = null;

        try {
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
                user.setlName(resultSet.getString("lName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return user;
    }
}
