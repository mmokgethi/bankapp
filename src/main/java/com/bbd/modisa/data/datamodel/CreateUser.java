package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.User;

import java.sql.*;

public class CreateUser implements AppData {
    private Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

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

    public int getAccId(int userId) throws SQLException {
        int user_id = 0;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            /*resultSet = statement.executeQuery("SELECT DISTINCT(accId) FROM User u, Account a WHERE " +
                    "User_userId = userId");*/

            String sql = "SELECT DISTINCT(accId) FROM Account a, User u WHERE User_userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user_id = resultSet.getInt("accId");
            }
            return user_id;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return user_id;
    }
}
