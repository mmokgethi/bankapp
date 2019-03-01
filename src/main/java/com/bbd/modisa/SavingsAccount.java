package com.bbd.modisa;

public class SavingsAccount extends Account {
    public SavingsAccount(Integer nextId, Double currBal, String accType)
    {
        super(nextId, currBal, accType);
    }

    /*public double withdraw(double amount)
    {
        if (getBalance() < amount)
        {
            System.out.println("You can't withdraw that amount, and you know why");
        }
            return super.withdrawal(amount);
    }*/
}

