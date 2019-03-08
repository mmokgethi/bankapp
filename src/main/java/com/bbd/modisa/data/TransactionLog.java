package com.bbd.modisa.data;

import com.bbd.modisa.model.AccountType;

import java.util.*;

public class TransactionLog{
    ArrayList<String> trans = new ArrayList<>();
    ArrayList<AccountType> account = new ArrayList<>();

    public void getDeposit(double dep)
    {
        trans.add("Deposit \tR: " + dep);
    }

    public void getWithdraw(double with)
    {
        trans.add("Withdrawal \tR: " + with);
    }

    public void getAccount(AccountType accType)
    {
        account.add(accType);
    }

    public void transactions()
    {
        TreeSet<String> set = new TreeSet<>(trans);
        Iterator<String> ascSorting = set.iterator();

        while (ascSorting.hasNext())
        {
            System.out.println(String.format(/*"R %.2f",*/ascSorting.next()));
        }
    }

    public void transactionsR()
    {
        Collections.sort(trans);
        for (int i = 0; i < trans.size(); i++)
        {
            String myLog = trans.get(i);
            System.out.println(String.format(/*"R %.2f", */myLog));
        }
    }

    public void accType()
    {
        for (int i = 0; i < account.size(); i ++)
        {
            AccountType myAcc = account.get(i);
            System.out.println(myAcc);
        }
    }
}