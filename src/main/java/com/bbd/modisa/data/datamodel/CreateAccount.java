package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.DataAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
    public void createAcc(DataAccount dataAccount) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Account(availBalance, User_userId, accType)" +
                    " VALUES(?, ?, ?)");
            preparedStatement.setDouble(1, dataAccount.getAvailBalance());
            preparedStatement.setInt(2, dataAccount.getUserId());
            preparedStatement.setString(3, dataAccount.getAccType());
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
}
