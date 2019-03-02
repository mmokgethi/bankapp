package com.bbd.modisa;

public class CheckAccount extends Account {
    private static Double checkTransFee = 3.5;


    public CheckAccount(int id, String accType)
    {
        super(id, accType);
    }

    //New balance after transaction fee
    public double balance()
    {
        return checkTransFee;
    }
}
