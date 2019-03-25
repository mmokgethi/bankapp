package com.bbd.modisa.client;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.data.datamodel.CreateAccount;
import com.bbd.modisa.data.datamodel.CreateTran;
import com.bbd.modisa.data.datamodel.CreateUser;
import com.bbd.modisa.data.datamodel.GetUser;
import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.User;
import com.bbd.modisa.model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Double amount;
    public static CreateAccount account = new CreateAccount();
    public static CreateTran tran = new CreateTran();
    public static CreateUser makeUser = new CreateUser();
    public static int userId;

    public static void createUser() throws SQLException {
        System.out.print("Enter your First Name: ");
        String fName = scanner.nextLine();

        System.out.print("Enter you Last Name: ");
        String lName = scanner.nextLine();

        User user = new User(fName, lName);
        makeUser.createUser(user);
        userId = makeUser.showId();
        System.out.println("Accounts created successfully, you user id is: " + userId);
    }

    public static void createAccount() throws SQLException {
        if (userId == 0){
            System.out.print("Enter your user id to create account of your choice: ");
            userId = scanner.nextInt();
        }else {
            Account account = null;

            System.out.print("Enter the type of account you would like to create: ");
            char accountType = scanner.next().charAt(0);

            if (accountType == 'C'){
                account = new Account(0D, userId, AccountType.Cheque.name());
            }else if (accountType == 'S'){
                account = new Account(0D, userId, AccountType.Savings.name());
            }
            BankApp.account.createAcc(account);
        }
    }

    public static void getUser() throws SQLException {
        if (userId == 0){
            System.out.print("Enter your user id: ");
            userId = scanner.nextInt();
        }else{
            GetUser  getUser = new GetUser();

            User user = getUser.getId(userId);
            Account account = getUser.getId(userId);

            System.out.println(account.getAccId() + ", " + user.getUserId() + ", "
                    + user.getfName() + ", "  + user.getlName() + ", " + account.getAccType() +
                    ", " + account.getAvailBalance());
        }
        System.out.println(userId);
    }

    public static void performTrans() throws SQLException {
        Transaction transaction = null;
        CreateAccount createAccount = new CreateAccount();

        System.out.print("Which transaction would you like to create: ");
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
        BankApp.tran.createTran(transaction);
    }

    public static void main(String[] args) throws SQLException {

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
            performTrans();
        }
    }
}
