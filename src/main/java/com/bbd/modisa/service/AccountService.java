package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;

public interface AccountService {

    Account createAccount(int accountNo);

    double deposit(double depositAmount);

    double withdraw(double withdrawalAmount);

    double getBalance();

}
