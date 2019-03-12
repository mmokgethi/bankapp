package com.bbd.modisa.model;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private Integer transactionId;

    private TransactionType transactionType;

    private Double amount;

    public Transaction(Integer transactionId, TransactionType transactionType, Double amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
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
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                '}';
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public List<String> getTrans() {
        return trans;
    }

    public void setTrans(List<String> trans) {
        this.trans = trans;
    }
}
