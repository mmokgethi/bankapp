package com.bbd.modisa.service;

import com.bbd.modisa.model.AccountType;

public class AccountServiceFactory {


    public AccountService getAccountService(AccountType accountType) {

        AccountService accountService = null;

        if (accountType == null)
            return null;

        if (accountType == AccountType.Savings) {
            accountService = new  SavingsAccountService();
        }
        else if (accountType == AccountType.Cheque)
        {
            accountService = new  SavingsAccountService();
        }
        return accountService;
    }


}
