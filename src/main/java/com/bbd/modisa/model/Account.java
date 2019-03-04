package com.bbd.modisa.model;


public class Account {
    private Integer id;
    private Double balance;
    private Double transFee;
    private AccountType accountType;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setGetType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Account(int nextId, AccountType acctType)
    {
        id = nextId;
        balance = 0D;
        this.accountType = acctType;
    }

    public Account(Integer nextId, Double currBalance, AccountType type)
    {
        id = nextId;
        balance = currBalance;
        this.accountType = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalance(Double currBalance) {
        balance = currBalance;
    }

    public Double getTransFee() {
        return transFee;
    }

    public void setTransFee(Double transFee) {
        this.transFee = transFee;
    }
}
