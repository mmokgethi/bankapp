package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;

public class CheckAccount extends Account implements Transaction {
    private static Double checkTransFee = 3.5;
    double myBal;


    public CheckAccount(int id, String accType)
    {
        super(id, accType);
    }



    public double deposit(double depositAmount) {
        myBal = ((getBalance() + depositAmount) - checkTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount) {
        if (withdrawalAmount > getBalance())
        {
            return 0;
        }
        else
        {
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;

        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
