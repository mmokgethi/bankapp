package com.bbd.modisa.client;

import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.AccountType;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.ChequeAccountService;
import com.bbd.modisa.service.SavingsAccountService;

import java.util.Scanner;

public class BankApp {
    private static AccountService accountService;
    private static char cont = 'Y';
    private static Scanner scanner = new Scanner(System.in);
    private static double amount;
    private static char accType;
    private static AccountType acctType;

    private static void createCheck()
    {
        accountService = new ChequeAccountService();
        Account newAccC = accountService.createAccount(1);
        System.out.println(newAccC.getAccountType() + " Account Created Successfully" + newAccC + "\n");

        while (cont == 'Y') {


            System.out.print("Which Action would you like to perform in your " + newAccC.getAccountType() +
                    " Account? Deposit(D)/Withdrawal(W)/Check Balance(C): ");
            char opt = scanner.next().charAt(0);

            if (opt == 'D') {
                System.out.print("Enter the amout you would like to Deposit: R ");
                Scanner depAmount = new Scanner(System.in);
                amount = depAmount.nextDouble();
                System.out.print("Your Current Balance = R " + accountService.deposit(amount));

            } else if (opt == 'W') {
                System.out.print("Enter the amount to Withdraw: R");
                Scanner withAmt = new Scanner(System.in);
                amount = withAmt.nextDouble();
                System.out.print("Withdraw Successfully\nYour Current Balance is R " + accountService.withdraw(amount));

            } else if (opt == 'C') {
                System.out.print("Your Current Balance is = R " + accountService.getBalance());
            }
            System.out.print("\nWould you like to perform another accountService?(Y/N): ");
            cont = scanner.next().charAt(0);
        }
    }

    private static void createSavings()
    {
        accountService = new SavingsAccountService();
        Account saving = accountService.createAccount(1);
        System.out.println(saving.getAccountType() + " Account Created Successfully" + saving+ "\n");

        while (cont == 'Y') {
            System.out.print("Which Action would you like to perform in your " + saving.getAccountType() +
                    " Account? Deposit(D)/Withdrawal(W)/Check Balance(C): ");
            char optS = scanner.next().charAt(0);
            if (optS == 'D') {
                Scanner depAmount = new Scanner(System.in);

                System.out.print("Enter the amout you would like to Deposit: R");
                amount = depAmount.nextDouble();

                System.out.print("Your Current Balance = R " + accountService.deposit(amount));
            } else if (optS == 'W') {
                Scanner withAmt = new Scanner(System.in);

                System.out.print("Enter the amount to Withdraw: R");
                amount = withAmt.nextDouble();

                accountService.withdraw(amount);
                System.out.print("Withdraw Successfully\nYour Current Balance is R " + accountService.getBalance());
            } else if (optS == 'C') {
                System.out.print("Your Current Balance is = R " + accountService.getBalance());
            }
            System.out.print("\nWould you like to perform another accountService?(Y/N): ");
            cont = scanner.next().charAt(0);
        }
    }


    public static void main(String[] args) {
        System.out.print("What type of account would you like to create? Cheque(C)/Savings(S): ");
        accType = scanner.next().charAt(0);

        if (accType == 'S')
            acctType = AccountType.Savings;
        else if (accType == 'C')
            acctType = AccountType.Cheque;
        else
            throw new AccountNotFoundException("Invalid Account");


        switch (acctType) {
            case Cheque:
                createCheck();
                break;
            case Savings:
                createSavings();
                break;
            default:
                System.out.print("Account Type doesn't exist");
        }
    }
}
