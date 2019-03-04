package com.bbd.modisa.model;

public class CheckAccount extends Account {
    //private static Double checkTransFee = 3.5;
    //double myBal;


    public CheckAccount(int id)
    {
        super(id, AccountType.Cheque);
    }
}
