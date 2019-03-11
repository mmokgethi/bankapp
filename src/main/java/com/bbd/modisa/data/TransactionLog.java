package com.bbd.modisa.data;

import com.bbd.modisa.model.AccountType;
import java.util.*;

public class TransactionLog{
    ArrayList<String> trans = new ArrayList<>();
    ArrayList<AccountType> account = new ArrayList<>();

    //Add all deposit transactions into ArrayList
    public void getDeposit(double dep)
    {
        trans.add("Deposit \tR: " + String.format("%.2f", dep));
    }

    //Add all withdrawals transactions into ArrayList
    public void getWithdraw(double withdraw)
    {
        trans.add("Withdrawal \tR: " + String.format("%.2f", withdraw));
    }

    //Add transaction type to the ArrayList
    public void getAccount(AccountType accType)
    {
        account.add(accType);
    }

    //Sort Transactions and remove duplicates
    public void transactions()
    {
        TreeSet<String> set = new TreeSet<>(trans);
        Iterator<String> ascSorting = set.iterator();

        while (ascSorting.hasNext())
        {
            System.out.println(String.format(/*"R %.2f",*/ascSorting.next()));
        }
    }

    //Sort all transactions
    public void transactionsR()
    {
        Collections.sort(trans);
        for (int i = 0; i < trans.size(); i++)
        {
            String myLog = trans.get(i);
            System.out.println(String.format(/*"R %.2f", */myLog));
        }
    }

    //Get transaction type
    public void accType()
    {
        for (int i = 0; i < account.size(); i ++)
        {
            AccountType myAcc = account.get(i);
            System.out.println(myAcc);
        }
    }
}