package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;

import java.util.Scanner;

public class CheckAccount extends Account {
    private static Double checkTransFee = 3.5;
    double myBal;


    public CheckAccount(int id, String accType)
    {
        super(id, accType);
    }

    public double dept()
    {
        double deposited;
        Scanner depAmount = new Scanner(System.in);

        System.out.print("Enter the amout you would like to Deposit: R" );
        deposited = depAmount.nextDouble();
        myBal = ((getMyBal() + deposited) - checkTransFee);
        return myBal;
    }

    public double withdrawC()
    {

        double withdraw;
        //double wBal;
        Scanner withAmt = new Scanner(System.in);

        System.out.print("Enter the amount to Withdraw: R" );
        withdraw = withAmt.nextDouble();


        if (withdraw > getMyBal())
        {
            System.out.print("Insufficient funds");
        }
        else
        {
            myBal = (getMyBal() - withdraw) - checkTransFee;

        }
        return myBal;
    }

    public double getMyBal() {
        return myBal;
    }
}
