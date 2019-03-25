package com.bbd.modisa.service;

import com.bbd.modisa.model.Accounts;

public interface AccountService {

    Accounts createAccount(int accountNo);

    double deposit(double depositAmount, Accounts accounts);

    double withdraw(double withdrawalAmount, Accounts accounts);

    double getBalance();

}
