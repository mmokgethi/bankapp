package com.bbd.modisa.service;

public interface Transaction {

    double deposit(double depositAmount);

    double withdraw(double withdrawalAmount);

    double getBalance();

}
