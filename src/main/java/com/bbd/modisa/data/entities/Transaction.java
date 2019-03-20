package com.bbd.modisa.data.entities;

public class Transaction {
    private int tranId;
    private Double amount;
    private Double balance;
    private int tranTypeCode;
    private int accId;
    private int userId;

    public Transaction(){

    }

    public Transaction(Double amount, Double balance, int tranTypeCode,
                       int accId, int userId) {
        this.amount = amount;
        this.balance = balance;
        this.tranTypeCode = tranTypeCode;
        this.accId = accId;
        this.userId = userId;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getTranTypeCode() {
        return tranTypeCode;
    }

    public void setTranTypeCode(int tranTypeCode) {
        this.tranTypeCode = tranTypeCode;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tranId=" + tranId +
                ", amount=" + amount +
                ", balance=" + balance +
                ", tranTypeCode=" + tranTypeCode +
                ", accId=" + accId +
                ", userId=" + userId +
                '}';
    }
}
