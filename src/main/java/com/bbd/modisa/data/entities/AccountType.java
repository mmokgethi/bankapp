package com.bbd.modisa.data.entities;

public class AccountType {
    private int accTypeCode;
    private String accTypeDesc;
    private int accId;

    public AccountType(){

    }

    public AccountType(String accTypeDesc, int accId){
        this.accTypeDesc = accTypeDesc;
        this.accId = accId;
    }

    public int getAccTypeCode() {
        return accTypeCode;
    }

    public void setAccTypeCode(int accTypeCode) {
        this.accTypeCode = accTypeCode;
    }

    public String getAccTypeDesc() {
        return accTypeDesc;
    }

    public void setAccTypeDesc(String accTypeDesc) {
        this.accTypeDesc = accTypeDesc;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accTypeCode=" + accTypeCode +
                ", accTypeDesc='" + accTypeDesc + '\'' +
                ", accId=" + accId +
                '}';
    }
}
