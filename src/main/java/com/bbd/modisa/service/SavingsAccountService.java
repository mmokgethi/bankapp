package com.bbd.modisa.service;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Accounts;
import com.bbd.modisa.model.SavingsAccount;
import com.bbd.modisa.model.Transaction;
import com.bbd.modisa.model.TransactionType;

import java.util.*;

public class SavingsAccountService implements AccountService {

    private static Double saveTransFee = 1.5;
    private double myBal;
    private static Transaction transactions;
    private static int counter = 0;

    public Accounts createAccount(int accountNo) {
        SavingsAccount savingsAccount = new SavingsAccount(accountNo);
        AccountDB.addAccount(savingsAccount);
        return savingsAccount;
    }

    public double deposit(double depositAmount, Accounts accounts) {
        counter++;
        //transactions = new Transaction(counter, TransactionType.DEPOSIT, depositAmount);
        AccountDB.updateAccount(accounts.getId(),transactions);
        myBal = ((getBalance() + depositAmount) - saveTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Accounts accounts) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        } else {
            //transactions = new Transaction(counter++, TransactionType.WITHDRAWAL, withdrawalAmount);
            AccountDB.updateAccount(accounts.getId(),transactions);
            myBal = (getBalance() - withdrawalAmount) - saveTransFee;

        }
        return myBal;
    }

    public void getAllTransactionSort()
    {
        TreeSet<Transaction> treeSet = new TreeSet<>(AccountDB.getAllTransactions(1));

        Iterator<Transaction> ascSorting = treeSet.iterator();
        while(ascSorting.hasNext()) {
            System.out.println(ascSorting.next());
        }
    }

    public double getBalance() {
        return myBal;
    }
}
