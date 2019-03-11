package com.bbd.modisa.model;


import java.util.ArrayList;
import java.util.List;

public class Account {
    private Integer id;
    private Double balance;
    private AccountType accountType;
    private List<Transaction> transactions;

    public AccountType getAccountType() {
        return accountType;
    }

    public Account(int nextId, AccountType acctType)
    {
        id = nextId;
        balance = 0D;
        this.accountType = acctType;
    }

    public List<Transaction> getTransactions() {
        return transactions == null ? new ArrayList<>() : transactions;
    }
}
