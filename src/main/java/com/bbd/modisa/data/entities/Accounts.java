package com.bbd.modisa.data.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
public class Accounts {
    private int accId;
    private double availableBal;
    private int userId;
    private String accountType;

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public double getAvailableBal() {
        return availableBal;
    }

    public void setAvailableBal(double availableBal) {
        this.availableBal = availableBal;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accId=" + accId +
                ", availableBal=" + availableBal +
                ", userId=" + userId +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
