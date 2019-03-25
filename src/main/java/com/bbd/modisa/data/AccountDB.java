package com.bbd.modisa.data;

import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.exception.TransactionNotFoundException;
import com.bbd.modisa.model.Accounts;
import com.bbd.modisa.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountDB {

    private static final List<Accounts> ACCOUNTS_LIST = new ArrayList<>();

    public static void addAccount(Accounts accounts) {
        ACCOUNTS_LIST.add(accounts);
    }

    public static Accounts updateAccount(int accountId, Transaction transaction) {
        for (Accounts accounts : ACCOUNTS_LIST) {
            if (accounts.getId() == accountId) {
                accounts.getTransactions().add(transaction);
                return accounts;
            }
        }
        throw new AccountNotFoundException("Account not found in the database");
    }

    public static List<Transaction> getAllTransactions(int accountNo) {
        for (Accounts accounts : ACCOUNTS_LIST) {
            if (accounts.getId() == accountNo) {
                System.out.println(accounts + "\n");
                return accounts.getTransactions();
            }
        }
        throw new AccountNotFoundException("Account detail not found");
    }

    public static Transaction getAccountTransaction(int accountId, int transactionId) {
        Accounts currentAccounts = null;
        for (Accounts accounts1 : ACCOUNTS_LIST) {
            if (accounts1.getId() == accountId) {
                currentAccounts = accounts1;
                break;
            }
        }
        if (currentAccounts != null) {
            for (Transaction transaction : currentAccounts.getTransactions()) {
                if (transaction.getTransactionId() == transactionId) {
                    return transaction;
                }
            }

        }
        throw new TransactionNotFoundException("Transactions with Id " +  transactionId + " is not found");
    }
}
