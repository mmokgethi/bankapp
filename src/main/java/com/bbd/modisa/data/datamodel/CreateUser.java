package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreateUser implements AppData {
    private Connection connection = null;
    PreparedStatement preparedStatement = null;

    public void createUser(User user) throws SQLException {
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO User(fName, lName)" +
                    "VALUES(?,?)");
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
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

    public int showId() throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        int maxUserId = 0;

        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT MAX(userId) FROM User");

            if (resultSet.next()){
                maxUserId = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return maxUserId;
    }

    public void getId() throws SQLException {
        User user = new User();
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement("SELECT MAX(userId) FROM User");
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                user.setUserId(resultSet.getInt("userId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
