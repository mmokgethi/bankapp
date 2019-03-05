package com.bbd.modisa.model;


public class Account {
    private Integer id;
    private Double balance;
    private AccountType accountType;

    public AccountType getAccountType() {
        return accountType;
    }

    public Account(int nextId, AccountType acctType)
    {
        id = nextId;
        balance = 0D;
        this.accountType = acctType;
    }
}
