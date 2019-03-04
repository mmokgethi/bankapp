package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.AccountType;

public interface AccountService {

    Account createAccount(int accountNo);

    double deposit(double depositAmount);

    double withdraw(double withdrawalAmount);

    double getBalance();

}
