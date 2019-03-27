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
    private int accId;

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

    private static Double availBalance;
    private int User_userId;
    public static String accType;

    public Account(){

    }



    public Account(Double availBalance, int userId, String accType){
        this.availBalance = availBalance;
        this.User_userId = userId;
        this.accType = accType;
    }



    public String getAccType() {
        return accType;
    }

    public static void setAccType(String accType) {
        Account.accType = accType;
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

    public static void setAvailBalance(Double availBalance) {
        Account.availBalance = availBalance;
    }

    public int getUser_userId() {
        return User_userId;
    }

    public void setUser_userId(int User_userId) {
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
