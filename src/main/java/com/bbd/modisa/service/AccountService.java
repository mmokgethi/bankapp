package com.bbd.modisa.service;

import com.bbd.modisa.model.AccountDto;
import com.bbd.modisa.model.TransactionDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    double deposit(double depositAmount, Integer accounts);

    double withdraw(double withdrawalAmount, Integer accountId);

    TransactionDto getTransactions(Integer userId);

    double getBalance();

}
