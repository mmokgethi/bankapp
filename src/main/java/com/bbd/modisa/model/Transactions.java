package com.bbd.modisa.model;

import java.util.ArrayList;
import java.util.List;

public class Transactions implements Comparable<Transactions> {

    private Integer transactionId;

    private String transactionType;
    private int accId;
    private int userId;
    private Double amount;


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

    public Transactions(){}
    public Transactions(Double amount, String transactionType, int accId, int userId) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.userId = userId;
        this.accId = accId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private List<String> trans = new ArrayList<>();

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", accId=" + accId +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public List<String> getTrans() {
        return trans;
    }

    public void setTrans(List<String> trans) {
        this.trans = trans;
    }

    @Override
    public int compareTo(Transactions transactions) {
        int compareId = ((Transactions) transactions).getTransactionId();
        return this.transactionId - compareId;
    }
}
