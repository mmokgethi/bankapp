package com.bbd.modisa.model;


public class SavingsAccount extends Account{
    public SavingsAccount(Integer nextId)
    {
        super(nextId, AccountType.Savings);
    }
}
