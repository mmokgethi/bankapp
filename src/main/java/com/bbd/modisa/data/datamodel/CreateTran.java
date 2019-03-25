package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTran  {


    public void   createTran(Transaction transaction) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Transactions transaction = new Transactions();


        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Transaction(amount, tranType, " +
                    "Account_accId, Account_User_userId) VALUES(?, ?, ?, ?)");

            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setString(2, transaction.getTransactionType());
            preparedStatement.setInt(3, transaction.getAccId());
            preparedStatement.setInt(4, transaction.getUserId());
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
