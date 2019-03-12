package com.bbd.modisa.service;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.SavingsAccount;
import com.bbd.modisa.model.Transaction;
import com.bbd.modisa.model.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccountService implements AccountService {

    private static Double saveTransFee = 1.5;
    private List<String> trans = new ArrayList<String>();
    private double myBal;
    private static Transaction transactions;

    public Account createAccount(int accountNo) {
        SavingsAccount savingsAccount = new SavingsAccount(accountNo);
        AccountDB.addAccount(savingsAccount);
        return savingsAccount;
    }

    public double deposit(double depositAmount, Account account) {
        transactions = new Transaction(1, TransactionType.DEPOSIT, depositAmount);
        //account.getTransactions().add(transactions);
        AccountDB.updateAccount(account.getId(),transactions);
        myBal = ((getBalance() + depositAmount) - saveTransFee);
        trans.add("Deposited: + " + depositAmount);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Account account) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        } else {
            transactions = new Transaction(1, TransactionType.WITHDRAWAL, withdrawalAmount);
            //account.getTransactions().add(transactions);
            AccountDB.updateAccount(account.getId(),transactions);
            myBal = (getBalance() - withdrawalAmount) - saveTransFee;
            //trans.add("Withdrawn: R" + withdrawalAmount);
        }
        return myBal;
    }

    public List<Transaction> getAllTransactions(int accountNo) {
        return AccountDB.getAllTransactions(accountNo);
    }

    public double getBalance() {
        return myBal;
    }
}
