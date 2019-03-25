package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
    private Connection connection = ConnectionConfig.getConnection();
    private PreparedStatement preparedStatement = null;

    public void createAcc(Account account) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Account(availBalance, User_userId, accType)" +
                    " VALUES(?, ?, ?)");
            preparedStatement.setDouble(1, account.getAvailBalance());
            preparedStatement.setInt(2, account.getUserId());
            preparedStatement.setString(3, account.getAccType());
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public void deposit(double balance, int accountId) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE Account SET availBalance = availBalance" +
                    "+ ? WHERE accId = ?");
            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public void withdrawal(double balance, int accountId) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE Account SET availBalance = availBalance" +
                    "- ? WHERE accId = ?");
            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
