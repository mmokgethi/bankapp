package com.bbd.modisa;

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

    //New balance after transaction fee
    public double balance()
    {
        return saveTransFee;
    }

    void withdrawal(double withdraw)
    {
        Scanner withAmt = new Scanner(System.in);

        System.out.print("Enter the amount to Withdraw: R" );
        withdraw = withAmt.nextDouble();

        if (withdraw > myBal)
        {
            System.out.print("Insufficient funds");
        }
        else
        {
            myBal -= withdraw;
            System.out.print("R " + withdraw + " Withdrawn Successfully\nYour Current Balance is = : R" + (myBal - saveTransFee));
        }

    }

    //Allow user to deposit into the account
    void deposit(double deposited)
    {
        Scanner depAmount = new Scanner(System.in);

        System.out.print("Enter the amout you would like to Deposit: R" );
        deposited = depAmount.nextDouble();
        myBal += deposited;
        System.out.print("Your Current Balance = R " + (myBal - saveTransFee));
    }

    public double getMyBal() {
        myBal += myBal;
        return myBal;
    }


}

