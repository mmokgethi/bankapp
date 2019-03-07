package com.bbd.modisa.data;

import com.bbd.modisa.model.AccountType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionLog{
    List<Double> trans = new ArrayList<Double>();

    public void getDeposit(double dep)
    {
        trans.add(dep);
    }

    public void getAccount(AccountType acc)
    {
        //trans.add(acc);
    }

    public void getWithdraw(double with)
    {
        trans.add(with);
    }

    public void transactions()
    {
        for (int i = 0; i < trans.size(); i++)
        {
            Double myLog = trans.get(i);
            System.out.println(myLog);
        }
        Collections.sort(trans);
    }
}