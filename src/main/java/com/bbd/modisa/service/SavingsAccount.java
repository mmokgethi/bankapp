package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;

public class SavingsAccount extends Account implements Transaction {
    public SavingsAccount(Integer nextId, Double currBal, String accType)
    {
        super(nextId, currBal, accType);
    }

    private static Double saveTransFee = 1.5;
    double myBal;

    public SavingsAccount(int id, String accType)
    {
        super(id, accType);
    }

    public double getMyBal() {
        return myBal;
    }

    public double deposit(double depositAmount) {
        myBal = ((getMyBal() + depositAmount) - saveTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount) {
        if (withdrawalAmount > getMyBal())
        {
            return 0;
        }
        else
        {
            myBal = (getMyBal() - withdrawalAmount) - saveTransFee;

        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}

