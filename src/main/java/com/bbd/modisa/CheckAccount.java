package com.bbd.modisa;

public class CheckAccount extends Account {
    public CheckAccount(Integer nextId, Double currBal, String accType)
    {
        super(nextId, currBal, accType);
    }

    /*public double withdraw(int amount)
    {
        if (getBalance() < amount)
        {
            System.out.println("Insufficient Funds");
        }
        return super.withdrawal(amount);
    }*/
}
