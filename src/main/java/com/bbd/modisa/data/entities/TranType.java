package com.bbd.modisa.data.entities;

public class TranType {
    private int tranTypeId;
    private String tranTypeDesc;

    public TranType(){

    }

    public TranType(String tranTypeDesc) {
        this.tranTypeDesc = tranTypeDesc;
    }

    public int getTranTypeId() {
        return tranTypeId;
    }

    public void setTranTypeId(int tranTypeId) {
        this.tranTypeId = tranTypeId;
    }

    public String getTranTypeDesc() {
        return tranTypeDesc;
    }

    public void setTranTypeDesc(String tranTypeDesc) {
        this.tranTypeDesc = tranTypeDesc;
    }

    @Override
    public String
    toString() {
        return "TranType{" +
                "tranTypeId=" + tranTypeId +
                ", tranTypeDesc='" + tranTypeDesc + '\'' +
                '}';
    }
}
