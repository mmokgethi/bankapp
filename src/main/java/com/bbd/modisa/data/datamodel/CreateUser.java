package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUser implements AppData {
    @Override
    public void createUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO User" +
                    "VALUES(?,?)");
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
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
