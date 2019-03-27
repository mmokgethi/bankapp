package com.bbd.modisa.model;


public class SavingsAccount extends Accounts {
    public SavingsAccount(Integer nextId) {
        super(nextId, AccountType.Savings);
    }
}
