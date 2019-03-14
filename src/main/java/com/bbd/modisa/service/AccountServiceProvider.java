package com.bbd.modisa.service;

import com.bbd.modisa.model.AccountType;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceProvider {

    private static Map<AccountType, AccountService> accountServiceCache = new HashMap<>();

    private AccountServiceProvider() {
    }

    public static AccountService getAccountService(AccountType accountType) {
        AccountService accountService = accountServiceCache.get(accountType);
        return accountService == null ? createAccountService(accountType) :
                accountService;
    }

    private static AccountService createAccountService(AccountType accountType) {
        AccountService accountService = accountType == AccountType.Cheque ? new ChequeAccountService() :
                new SavingsAccountService();
        accountServiceCache.put(accountType, accountService);
        System.out.println("get account service");
        return accountService;
    }
}
