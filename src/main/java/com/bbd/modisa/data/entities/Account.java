package com.bbd.modisa.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accId")
    private Integer accId;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "User_userId")
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    public Set<Transaction> transactions = new TreeSet<>();

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    private  Double availBalance;
    @Column(name = "User_userId", unique = true, nullable = false)
    private Integer User_userId;
    public  String accType;

    public Account(){

    }



    public Account(Double availBalance, Integer userId, String accType){
        this.availBalance = availBalance;
        this.User_userId = userId;
        this.accType = accType;
    }



    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Double getAvailBalance() {
        return availBalance;
    }

    public void setAvailBalance(Double availBalance) {
        this.availBalance = availBalance;
    }

    public int getUser_userId() {
        return User_userId;
    }

    public void setUser_userId(Integer User_userId) {
        this.User_userId = User_userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accId=" + accId +
                ", availBalance=" + availBalance +
                ", userId=" + User_userId +
                '}';
    }
}
