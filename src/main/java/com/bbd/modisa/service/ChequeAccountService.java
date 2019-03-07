package com.bbd.modisa.service;

import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.CheckAccount;

public class ChequeAccountService implements AccountService {

    private static Double checkTransFee = 3.5;
    private double myBal;

    public ChequeAccountService(){}

    public Account createAccount(int accountNo) {
        return new CheckAccount(accountNo);
    }

    public double deposit(double depositAmount) {
        myBal = ((getBalance() + depositAmount) - checkTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
         else {
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;
        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
