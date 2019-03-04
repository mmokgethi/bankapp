package com.bbd.modisa.service;

import com.bbd.modisa.model.Account;

import java.util.Scanner;

public class SavingsAccount extends Account {
    public SavingsAccount(Integer nextId, Double currBal, String accType)
    {
        super(nextId, currBal, accType);
    }

    private static Double saveTransFee = 1.5;
    double myBal;

    public SavingsAccount(int id, String accType)
    {
        super(id, accType);
    }

    public double dept()
    {
        double deposited;
        Scanner depAmount = new Scanner(System.in);

        System.out.print("Enter the amout you would like to Deposit: R" );
        deposited = depAmount.nextDouble();
        myBal = ((getMyBal() + deposited) - saveTransFee);
        return myBal;
    }

    public double withdraw()
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
            myBal = (getMyBal() - withdraw) - saveTransFee;

        }
        return myBal;
    }

    public double getMyBal() {
        return myBal;
    }
}

