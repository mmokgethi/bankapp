package com.bbd.modisa.data.entities;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class DataAccount {
    private int accId;
    private Double availBalance;
    private int userId;
    public String accType;

    public DataAccount(){

    }

    public DataAccount(Double availBalance, int userId, String accType){
        this.availBalance = availBalance;
        this.userId = userId;
        this.accType = accType;
    }

    public int getAccId() {
        return accId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public Double getAvailBalance() {
        return availBalance;
    }

    public void setAvailBalance(Double availBalance) {
        this.availBalance = availBalance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DataAccount{" +
                "accId=" + accId +
                ", availBalance=" + availBalance +
                ", userId=" + userId +
                '}';
    }
}
