package com.bbd.modisa.data.entities;

public class Transactions {
    private int tranId;
    private Double amount;
    private String tranType;
    private int accId;
    private int userId;

    public Transactions(){

    }

    public Transactions(Double amount, String tranType,
                        int accId, int userId) {
        this.amount = amount;
        this.tranType = tranType;
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

    public String getTranType() {
        return tranType;
    }

    public void setTranTypeCode(String tranTypeCode) {
        this.tranType = tranTypeCode;
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
        return "Transactions{" +
                "tranId=" + tranId +
                ", amount=" + amount +
                ", tranTypeCode=" + tranType +
                ", accId=" + accId +
                ", userId=" + userId +
                '}';
    }
}
