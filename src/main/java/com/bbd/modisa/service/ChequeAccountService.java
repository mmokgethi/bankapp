package com.bbd.modisa.service;

import com.bbd.modisa.data.TransactionLog;
import com.bbd.modisa.exception.InsufficientFundsException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.CheckAccount;

import java.util.ArrayList;
import java.util.List;

public class ChequeAccountService implements AccountService {

    private static Double checkTransFee = 3.5;
    private double myBal;
    //private List<String> trans = new ArrayList<String>();
    TransactionLog tl = new TransactionLog();

    public ChequeAccountService(){}

    public Account createAccount(int accountNo) {
        return new CheckAccount(accountNo);
    }

    public double deposit(double depositAmount) {
        myBal = ((getBalance() + depositAmount) - checkTransFee);
        //trans.add("Deposited: + " + depositAmount);
        return myBal;
    }

    public double withdraw(double withdrawalAmount) {
        if (withdrawalAmount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
         else {
            myBal = (getBalance() - withdrawalAmount) - checkTransFee;
            //trans.add("Withdrawn: R" + withdrawalAmount);
        }
        return myBal;
    }

    /*public void transactions()
    {
        for (int i = 0; i < trans.size(); i++)
        {
            String myLog = trans.get(i);
            System.out.println(myLog);
        }
    }*/

    public double getBalance() {
        return myBal;
    }
}
