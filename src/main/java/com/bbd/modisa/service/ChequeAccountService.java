package com.bbd.modisa.service;

import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Accounts;
import com.bbd.modisa.model.CheckAccount;
import com.bbd.modisa.model.Transactions;

public class ChequeAccountService implements AccountService {

    private static Double checkTransFee = 3.5;
    private double myBal;
    private static Transactions trans;

    public Accounts createAccount(int accountNo) {
        return new CheckAccount(accountNo);
    }


    public double deposit(double depositAmount, Accounts accountsNo) {
        //trans = new Transactions(1, TransactionType.DEPOSIT,depositAmount);
        accountsNo.getTransactions().add(trans);
        myBal = ((getBalance() + depositAmount) - checkTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Accounts accountsNo) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        else {
            //trans = new Transactions(1, TransactionType.WITHDRAWAL, withdrawalAmount);
            accountsNo.getTransactions().add(trans);
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;
        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
