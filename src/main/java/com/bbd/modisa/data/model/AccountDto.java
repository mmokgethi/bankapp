package com.bbd.modisa.data.model;

public class AccountDto {
    private         Integer accId;
    private   Double availBalance;
    private   String accType;
    private         Integer User_userId;

    public AccountDto(){

    }

    public AccountDto(Double availBalance, Integer User_userId, String accType){
        this.availBalance = availBalance;
        this.User_userId = User_userId;
        this.accType = accType;
    }

    public  Integer getUser_userId() {
        return User_userId;
    }

    public  void setUser_userId(Integer user_userId) {
        User_userId = user_userId;
    }

    public  String getAccType() {
        return accType;
    }

    public  void setAccType(String accType) {
        this.accType = accType;
    }

    public  Integer getAccId() {
        return accId;
    }

    public  void setAccId(Integer accId) {
        this.accId = accId;
    }

    public  Double getAvailBalance() {
        return availBalance;
    }

    public  void setAvailBalance(Double availBalance) {
        this.availBalance = availBalance;
    }
}
