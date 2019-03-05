package com.bbd.modisa.service;

import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.SavingsAccount;

public class SavingsAccountService implements AccountService {

    private static Double saveTransFee = 1.5;
    private double myBal;

    public Account createAccount(int accountNo) {
        return new SavingsAccount(accountNo);
    }

    public double deposit(double depositAmount) {
        myBal = ((getBalance() + depositAmount) - saveTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        } else {
            myBal = (getBalance() - withdrawalAmount) - saveTransFee;

        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
