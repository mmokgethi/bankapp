package com.bbd.modisa.client;

import com.bbd.modisa.data.datamodel.CreateAccount;
import com.bbd.modisa.data.datamodel.CreateTran;
import com.bbd.modisa.data.datamodel.CreateUser;
import com.bbd.modisa.data.datamodel.GetUser;
import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.data.entities.User;
import com.bbd.modisa.model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    public static CreateAccount account = new CreateAccount();
    public static CreateTran tran = new CreateTran();
    public static CreateUser makeUser = new CreateUser();
    public static int userId;

    public static void createUser() {
        System.out.print("Enter your First Name: ");
        String fName = scanner.nextLine();

        System.out.print("Enter you Last Name: ");
        String lName = scanner.nextLine();


        User user = new User(fName, lName);
        makeUser.createUser(user);
        System.out.println(makeUser.showId());
        userId = makeUser.showId();
        System.out.println("User created successfully, you user id is: " + userId);
    }

    public static void createAccount() {
        if (userId == 0) {
            System.out.print("Enter your user id to create account of your choice: ");
            userId = scanner.nextInt();
        }
        Account account = null;

        System.out.println(userId);
        System.out.print("Enter the type of account you would like to create: ");
        char accountType = scanner.next().charAt(0);

        if (accountType == 'C'){
            account = new Account(0D, userId, AccountType.Cheque.name());
        }else if (accountType == 'S'){
            account = new Account(0D, userId, AccountType.Savings.name());
        }
        BankApp.account.createAcc(account);
    }

    public static void getUser() {
        if (userId == 0){
            System.out.print("Enter your user id: ");
            userId = scanner.nextInt();
        }else{
            GetUser  getUser = new GetUser();
        }
    }

    public static void performTrans() {
        Transaction transaction = null;
        CreateAccount createAccount = new CreateAccount();

        System.out.print("Which transactions would you like to create: ");
        char tranType = scanner.next().charAt(0);

        if (tranType == 'D'){
            System.out.print("Enter the amount you would like to deposit: ");
            Double amount = scanner.nextDouble();
            transaction = new Transaction(amount, TransactionType.DEPOSIT.name(), makeUser.getAccId(userId), userId);
            createAccount.deposit(amount, makeUser.getAccId(userId));
        }else if (tranType == 'W'){
            System.out.print("Enter the amount you would like to withdraw: ");
            Double amount = scanner.nextDouble();
            transaction = new Transaction(amount, TransactionType.WITHDRAWAL.name(), makeUser.getAccId(userId), userId);
            createAccount.withdrawal(amount, makeUser.getAccId(userId));
        }
        tran.createTran(transaction);
    }

    public static void getTrans(){
        GetUser getUser = new GetUser();

        getUser.listAll();
    }

    public static void getTranById(){
        GetUser getUser = new GetUser();

        System.out.println(getUser.findById(81));
    }

    public static void main(String[] args){

        System.out.print("Enter (N) for New Accounts/(E) to login: ");
        char userType = scanner.next().charAt(0);
        scanner.nextLine();

        if (userType == 'N'){
            createUser();
            createAccount();
            getUser();
            performTrans();
        }else if (userType == 'E'){
            getUser();
            System.out.print("Check Balance(B)/Get Statement(S)/Perform Transactions(T): ");
            char opt = scanner.next().charAt(0);
            if (opt == 'B'){

            }else if (opt == 'S'){
                getTranById();
            }else if (opt == 'T'){
                performTrans();
            }
        }
    }
}
