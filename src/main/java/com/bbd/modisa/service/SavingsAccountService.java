package com.bbd.modisa.service;

import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccountService implements AccountService {

    private static Double saveTransFee = 1.5;
    private List<String> trans = new ArrayList<String>();
    private double myBal;

    public Account createAccount(int accountNo) {
        return new SavingsAccount(accountNo);
    }

    public double deposit(double depositAmount, Account account) {
        myBal = ((getBalance() + depositAmount) - saveTransFee);
        trans.add("Deposited: + " + depositAmount);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Account account) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        } else {
            myBal = (getBalance() - withdrawalAmount) - saveTransFee;
            trans.add("Withdrawn: R" + withdrawalAmount);
        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
