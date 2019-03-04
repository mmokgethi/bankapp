package com.bbd.modisa;


public class Account {
    private Integer id;
    private Double balance;
    private Double transFee;
    private String accountType;

    Account(int nextId, String acctType)
    {
        id = nextId;
        balance = 0D;
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


}
