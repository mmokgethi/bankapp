package com.bbd.modisa.data.datamodel;

import com.bbd.modisa.data.entities.User;

import java.sql.SQLException;

public interface AppData {
    public void createUser(User user) throws SQLException;
}
