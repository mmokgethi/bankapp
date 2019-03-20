package com.bbd.modisa.client;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.data.ConnectionConfig;
import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.model.*;
import com.bbd.modisa.service.*;

import java.sql.Connection;
import java.util.EnumMap;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Double amount;
    private static int accountNo = 0;

    public static void createUser()
    {
        System.out.print("Enter your FirstName: ");
        String fName = scanner.nextLine();

    }




























    private static void chequeSavings(AccountService accountServices) {
        accountNo++;
        char cont = 'Y';
        Account saving = accountServices.createAccount(accountNo);
        System.out.println(saving.getAccountType() + " Account Created Successfully"/* + saving+ "\n"*/);

        Account account = new Account(1, saving.getAccountType());

        while (cont == 'Y') {
            System.out.print("Which Action would you like to perform in your " + saving.getAccountType() +
                    " Account? Deposit(D)/Withdrawal(W)/Check Balance(C)/Transaction Log(L): ");
            char optS = scanner.next().charAt(0);
            if (optS == 'D') {
                deposit();
                System.out.print("Your Current Balance = R " + String.format("%.2f",accountServices.deposit(amount, saving)));
            } else if (optS == 'W') {
                withdrawal();

                accountServices.withdraw(amount, account);
                System.out.print("Withdraw Successfully\nYour Current Balance is R " +
                        String.format("%.2f",accountServices.getBalance()));
            } else if (optS == 'C') {
                System.out.print("Your Current Balance is = R " + String.format("%.2f",  accountServices.getBalance()));
            } else if (optS == 'L') {
                AccountDB.getAllTransactions(accountNo);
                log(new SavingsAccountService());
            }
            System.out.print("\nWould you like to perform another accountService?(Y/N): ");
            cont = scanner.next().charAt(0);
        }
    }


    public static void deposit() {
        Scanner depAmount = new Scanner(System.in);

        System.out.print("Enter the amount you would like to Deposit: R");
        amount = depAmount.nextDouble();
    }

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = ConnectionConfig.getConnection();
            if (connection != null){
                System.out.println("connection established");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        char accType;
        do {
            System.out.print("What type of account would you like to create? Cheque(C)/Savings(S): ");
            accType = scanner.next().charAt(0);
            AccountService accountService = createAccountService(accType);
            chequeSavings(accountService);
            System.out.println("Would you like to continue?");
            accType = scanner.next().charAt(0);
        } while (accType != 'T');
    }

    private static void withdrawal() {
        Scanner withAmt = new Scanner(System.in);

        System.out.print("Enter the amount to Withdraw: R");
        amount = withAmt.nextDouble();
    }

    private static void log(SavingsAccountService savingsAccountService) {
        System.out.print("How would you like to sort your Log? From High(H)/From Low(L): ");
        char opt = scanner.next().charAt(0);
        if (opt == 'H') {
            savingsAccountService.getAllTransactionSort();
        }
        else if (opt == 'L') {
            System.out.print("Enter transaction id you would like to retrieve: ");
            int tranId = scanner.nextInt();

            System.out.println(AccountDB.getAccountTransaction(accountNo, tranId));
        }
    }

    private static AccountService createAccountService(char accType) {
        AccountServiceFactory accountServiceFactory = new AccountServiceFactory();
        AccountType acctType;

        if (accType == 'S')
            acctType = AccountType.Savings;
        else if (accType == 'C')
            acctType = AccountType.Cheque;
        else
            throw new AccountNotFoundException("Invalid Account");
        return accountServiceFactory.getAccountService(acctType);
    }
}
