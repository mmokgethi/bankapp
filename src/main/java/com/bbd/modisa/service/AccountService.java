package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.Transaction;

import java.util.List;

public interface AccountService {

    Account createAccount(int accountNo);

    double deposit(double depositAmount, Account account);

    double withdraw(double withdrawalAmount, Account account);

    List<Transaction> getAllTransactions(int accountNo);
    double getBalance();

}
