package com.bbd.modisa.service;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.CheckAccount;
import com.bbd.modisa.model.Transaction;
import com.bbd.modisa.model.TransactionType;

import java.util.List;

public class ChequeAccountService implements AccountService {

    private static Double checkTransFee = 3.5;
    private double myBal;
    private static Transaction trans;

    public Account createAccount(int accountNo) {
        return new CheckAccount(accountNo);
    }


    public double deposit(double depositAmount,Account accountNo) {
        trans = new Transaction(1, TransactionType.DEPOSIT,depositAmount);
        accountNo.getTransactions().add(trans);
        myBal = ((getBalance() + depositAmount) - checkTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Account accountNo) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        else {
            trans = new Transaction(1, TransactionType.WITHDRAWAL, withdrawalAmount);
            accountNo.getTransactions().add(trans);
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;
        }
        return myBal;
    }

    public double getBalance() {
        return myBal;
    }
}
