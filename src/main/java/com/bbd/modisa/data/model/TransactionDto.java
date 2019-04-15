package com.bbd.modisa.data.model;

public class TransactionDto {
    private int tranId;
    private Double amount;
    private String tranType;
    private Integer Account_accId;
    private Integer Account_User_userId;

    public TransactionDto(){

    }

    public TransactionDto(Double amount, String tranType, Integer account_accId, Integer account_User_userId) {
        this.amount = amount;
        this.tranType = tranType;
        Account_accId = account_accId;
        Account_User_userId = account_User_userId;
    }

    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Integer getAccount_accId() {
        return Account_accId;
    }

    public void setAccount_accId(Integer account_accId) {
        Account_accId = account_accId;
    }

    public Integer getAccount_User_userId() {
        return Account_User_userId;
    }

    public void setAccount_User_userId(Integer account_User_userId) {
        Account_User_userId = account_User_userId;
    }
}
