package com.bbd.modisa.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tranId")
    private int tranId;

    private Double amount;
    private String tranType;
    private int Account_accId;
    private int Account_User_userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "Account_accId")
    private Account account;


    public Transaction(){

    }

    public Transaction(Double amount, String tranType,
                       int Account_accId, int Account_User_userId) {
        this.amount = amount;
        this.tranType = tranType;
        this.Account_accId = Account_accId;
        this.Account_User_userId = Account_User_userId;
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

    public int getAccount_accId() {
        return Account_accId;
    }

    public void setAccount_accId(int account_accId) {
        Account_accId = account_accId;
    }

    public int getAccount_User_userId() {
        return Account_User_userId;
    }

    public void setAccount_User_userId(int account_User_userId) {
        Account_User_userId = account_User_userId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tranId=" + tranId +
                ", amount=" + amount +
                ", tranTypeCode=" + tranType +
                ", accId=" + Account_accId +
                ", userId=" + Account_User_userId +
                '}';
    }
}
