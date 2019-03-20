package com.bbd.modisa.data.entities;

public class Account {
    private int accId;
    private Double availBalance;
    private int userId;

    public Account(){

    }

    public Account(Double availBalance, int userId){
        this.availBalance = availBalance;
        this.userId = userId;
    }

    public int getAccId() {
        return accId;
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
        return "Account{" +
                "accId=" + accId +
                ", availBalance=" + availBalance +
                ", userId=" + userId +
                '}';
    }
}
