package com.bbd.modisa.model;


import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private Integer id;
    private Double balance;
    private AccountType accountType;
    private List<Transaction> transactions = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", transactions=" + transactions +
                '}';
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Accounts(int nextId, AccountType acctType) {
        id = nextId;
        balance = 0D;
        this.accountType = acctType;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return transactions == null ? new ArrayList<>() : transactions;
    }
}
