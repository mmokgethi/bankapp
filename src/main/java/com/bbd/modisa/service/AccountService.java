package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.data.model.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    double deposit(double depositAmount, Integer accounts);

    double withdraw(double withdrawalAmount, Integer accountId);

    List<Transaction> getTransactions(Integer userId);

    double getBalance();

}
