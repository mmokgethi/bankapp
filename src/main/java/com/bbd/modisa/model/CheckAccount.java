package com.bbd.modisa.model;

public class CheckAccount extends Account {
    public CheckAccount(int id)
    {
        super(id, AccountType.Cheque);
    }
}
