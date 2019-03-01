package com.bbd.modisa;

import java.util.Date;
import java.util.Scanner;

public class Account {
    private Integer id;
    private Double balance;
    private Double transFee;
    private String accountType;

    Account(int nextId, double currBalance, String acctType)
    {
        id = nextId;
        balance = currBalance;
        accountType = acctType;
    }

    public Account(Integer nextId, Double currBalance, String type)
    {
        id = nextId;
        balance = currBalance;
        accountType = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double currBalance) {
        balance = currBalance;
    }

    public Double getTransFee() {
        return transFee;
    }

    public void setTransFee(Double transFee) {
        this.transFee = transFee;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    //Allow user to withdraw
    void withdrawal()
    {

        Double withdraw;
        Scanner withAmt = new Scanner(System.in);

        System.out.print("Enter the amount to Withdraw: R" );
        withdraw = withAmt.nextDouble();

        if (withdraw > balance)
        {
            System.out.print("Insufficient funds");
        }
        else
        {
            balance -= withdraw;
            System.out.print("R " + withdraw + " Withdrawn Successfully\nYour Current Balance is = : R" + balance);
        }

    }

    //Allow user to deposit into the account
    void deposit()
    {
        Double deposited;
        Scanner depAmount = new Scanner(System.in);

        System.out.print("Enter the amout you would like to Deposit: R" );
        deposited = depAmount.nextDouble();
        balance += deposited;
        System.out.print("Your Current Balance = R " + balance);
    }
}
