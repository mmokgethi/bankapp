package com.bbd.modisa.service;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.SavingsAccount;
import com.bbd.modisa.model.Transaction;
import com.bbd.modisa.model.TransactionType;

import java.util.*;

public class SavingsAccountService implements AccountService {

    private static Double saveTransFee = 1.5;
    private List<String> trans = new ArrayList<String>();
    private double myBal;
    private static Transaction transactions;
    private static int counter = 0;
    private static SavingsAccountService savingsAccountService;


    public static SavingsAccountService getSavingsAccountService() {
        if (savingsAccountService == null){
            savingsAccountService = new SavingsAccountService();
        }
        return savingsAccountService;
    }

    public Account createAccount(int accountNo) {
        SavingsAccount savingsAccount = new SavingsAccount(accountNo);
        AccountDB.addAccount(savingsAccount);
        return savingsAccount;
    }

    public double deposit(double depositAmount, Account account) {
        counter++;
        transactions = new Transaction(counter, TransactionType.DEPOSIT, depositAmount);
        AccountDB.updateAccount(account.getId(),transactions);
        myBal = ((getBalance() + depositAmount) - saveTransFee);
        return myBal;
    }

    public double withdraw(double withdrawalAmount, Account account) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        } else {
            transactions = new Transaction(counter++, TransactionType.WITHDRAWAL, withdrawalAmount);
            AccountDB.updateAccount(account.getId(),transactions);
            myBal = (getBalance() - withdrawalAmount) - saveTransFee;

        }
        return myBal;
    }

    public List<Transaction> getAllTransactions(int accountNo) {
        return AccountDB.getAllTransactions(counter++);
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
