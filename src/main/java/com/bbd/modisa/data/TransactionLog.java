package com.bbd.modisa.data;

import java.util.*;

public class TransactionLog{
    ArrayList<Double> trans = new ArrayList<>();

    public void getDeposit(double dep)
    {
        trans.add(dep);
    }

    public void getWithdraw(double with)
    {
        trans.add(with);
    }

    public void transactions()
    {
        TreeSet<Double> set = new TreeSet<>(trans);
        Iterator<Double> ascSorting = set.iterator();

        while (ascSorting.hasNext())
        {
            System.out.println(ascSorting.next());
        }
    }

    public void transactionsR()
    {
        //Collections.sort(trans);
        for (int i = 0; i < trans.size(); i++)
        {
            Double myLog = trans.get(i);
            System.out.println(myLog);
        }
    }
}