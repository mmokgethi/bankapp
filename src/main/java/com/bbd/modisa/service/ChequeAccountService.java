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
    private static ChequeAccountService chequeAccountService;

    private ChequeAccountService()
    {}

    public Account createAccount(int accountNo) {
        return new CheckAccount(accountNo);
    }

    public static ChequeAccountService getChequeAccountService()
    {
        if (chequeAccountService == null)
        {
            chequeAccountService = new ChequeAccountService();
        }
        return chequeAccountService;
    }

    public double deposit(double depositAmount,Account accountNo) {
        trans = new Transaction(1, TransactionType.DEPOSIT,depositAmount);
        accountNo.getTransactions().add(trans);
        //AccountDB.updateAccount(accountNo.getId(),trans);
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
            //AccountDB.updateAccount(accountNo.getId(),trans);
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;
        }
        return myBal;
    }

    public List<Transaction> getAllTransactions(int account) {
        return AccountDB.getAllTransactions(1);
    }

    public double getBalance() {
        return myBal;
    }
}
