package com.bbd.modisa.data.entities;

public class User {
    private int userId;
    private String fName;
    private String lName;

    public User(){

    }

    public User(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
