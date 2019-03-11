package com.bbd.modisa.service;

import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.CheckAccount;
import com.bbd.modisa.model.Transaction;
import com.bbd.modisa.model.TransactionType;

public class ChequeAccountService implements AccountService {

    private static Double checkTransFee = 3.5;
    private double myBal;

    public Account createAccount(int accountNo) {
        return new CheckAccount(accountNo);
    }

    public double deposit(double depositAmount,Account accountNo) {
        Transaction transaction = new Transaction(1, TransactionType.DEPOSIT,depositAmount);
        accountNo.getTransactions().add(transaction);
        myBal = ((getBalance() + depositAmount) - checkTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Account accountNo) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
         else {
             Transaction transaction = new Transaction(1, TransactionType.WITHDRAWAL, withdrawalAmount);
             accountNo.getTransactions().add(transaction);
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;
        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
