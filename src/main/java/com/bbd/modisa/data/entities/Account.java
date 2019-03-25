package com.bbd.modisa.data.entities;

public class Account {
    private static int accId;
    private static Double availBalance;
    private int userId;
    public static String accType;

    public Account(){

    }

    public Account(Double availBalance, int userId, String accType){
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

    public static void setAccType(String accType) {
        Account.accType = accType;
    }

    public static void setAccId(int accId) {
        Account.accId = accId;
    }

    public Double getAvailBalance() {
        return availBalance;
    }

    public static void setAvailBalance(Double availBalance) {
        Account.availBalance = availBalance;
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