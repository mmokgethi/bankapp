package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.model.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    double deposit(double depositAmount, Integer accounts);

    double withdraw(double withdrawalAmount, Integer accountId);

    Transaction getTransactions(Integer userId);

    double getBalance();

}
