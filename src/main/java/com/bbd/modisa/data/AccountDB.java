package com.bbd.modisa.data;

import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.exception.TransactionNotFoundException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountDB {

    private static final List<Account> ACCOUNT_LIST = new ArrayList<>();

    public static void addAccount(Account account) {
        ACCOUNT_LIST.add(account);
    }

    public static Account updateAccount(int accountId, Transaction transaction) {
        for (Account account : ACCOUNT_LIST) {
            if (account.getId() == accountId) {
                account.getTransactions().add(transaction);
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found in the database");
    }

    public static List<Transaction> getAllTransactions(int accountNo) {
        for (Account account : ACCOUNT_LIST) {
            if (account.getId() == accountNo) {
                System.out.println(account + "\n");
                return account.getTransactions();
            }
        }
        throw new AccountNotFoundException("Account detail not found");
    }

    public static Transaction getAccountTransaction(int accountId, int transactionId) {
        Account currentAccount = null;
        for (Account account1 : ACCOUNT_LIST) {
            if (account1.getId() == accountId) {
                currentAccount = account1;
                break;
            }
        }
        if (currentAccount != null) {
            for (Transaction transaction : currentAccount.getTransactions()) {
                if (transaction.getTransactionId() == transactionId) {
                    return transaction;
                }
            }

        }
        throw new TransactionNotFoundException("Transaction with Id " +  transactionId + " is not found");
    }
}
