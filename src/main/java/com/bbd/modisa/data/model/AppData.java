package com.bbd.modisa.data.model;

import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.User;

import java.sql.SQLException;

public interface AppData {
    User createUser(User user) throws SQLException;
    Account createAccount(Account account);
}
