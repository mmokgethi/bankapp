package com.bbd.modisa.Data;

import com.bbd.modisa.model.AccountType;
import com.bbd.modisa.service.ChequeAccountService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransactionLog{
    List<ChequeAccountService> chequeTran = new ArrayList<ChequeAccountService>();
    private AccountType accT;
    String tranLog;

    public void getTranLog() {
        chequeTran.add(new ChequeAccountService());

        Iterator itr  = chequeTran.iterator();

        while (itr.hasNext())
        {
            ChequeAccountService cas = (ChequeAccountService)itr.next();
            System.out.println("Deposits: " + cas.getBalance());
        }
    }

    public AccountType getAccT() {
        return accT;
    }
}
