package com.bbd.modisa.model;

public class UserDto {

    private int userId;

    private String fName;

    private String lName;

    public UserDto(){}

    public UserDto(String fName, String lName) {
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
}
