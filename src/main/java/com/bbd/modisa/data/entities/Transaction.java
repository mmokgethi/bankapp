package com.bbd.modisa.data.entities;

import com.bbd.modisa.model.Transactions;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Transaction extends Transactions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tranId")
    private int tranId;

    private Double amount;
    private String tranType;
    private int accId;
    private int userId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "accId")
    private Account account;


    public Transaction(){

    }

    public Transaction(Double amount, String tranType,
                       int accId, int userId) {
        this.amount = amount;
        this.tranType = tranType;
        this.accId = accId;
        this.userId = userId;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        return "Transaction{" +
                "tranId=" + tranId +
                ", amount=" + amount +
                ", tranTypeCode=" + tranType +
                ", accId=" + accId +
                ", userId=" + userId +
                '}';
    }
}
