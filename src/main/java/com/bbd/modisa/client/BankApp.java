package com.bbd.modisa.client;

import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.AccountType;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.ChequeAccountService;
import com.bbd.modisa.service.SavingsAccountService;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char accType;

        AccountType acctType;

        System.out.print("What type of account would you like to create? Cheque(C)/Savings(S): ");
        accType = scanner.next().charAt(0);

        if (accType == 'S')
            acctType = AccountType.Savings;
        else if (accType == 'C')
            acctType = AccountType.Cheque;
        else
            throw new AccountNotFoundException("Invalid Account");


        AccountService accountService;

        switch (acctType) {
            case Cheque:
                char cont;
                double cash;

                cont = 'Y';
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
                        cash = depAmount.nextDouble();
                        System.out.print("Your Current Balance = R " + accountService.deposit(cash));

                    } else if (opt == 'W') {
                        System.out.print("Enter the amount to Withdraw: R");
                        Scanner withAmt = new Scanner(System.in);
                        cash = withAmt.nextDouble();
                        System.out.print("Withdraw Successfully\nYour Current Balance is R " + accountService.withdraw(cash));

                    } else if (opt == 'C') {
                        System.out.print("Your Current Balance is = R " + accountService.getBalance());
                    }
                    System.out.print("\nWould you like to perform another accountService?(Y/N): ");
                    cont = scanner.next().charAt(0);
                }
                break;
            case Savings:
                accountService = new SavingsAccountService();
                Account saving = accountService.createAccount(1);
                System.out.println(saving.getAccountType() + " Account Created Successfully" + saving+ "\n");
                double depositAmount;

                cont = 'Y';

                while (cont == 'Y') {
                    System.out.print("Which Action would you like to perform in your " + saving.getAccountType() +
                            " Account? Deposit(D)/Withdrawal(W)/Check Balance(C): ");
                    char optS = scanner.next().charAt(0);
                    if (optS == 'D') {
                        Scanner depAmount = new Scanner(System.in);

                        System.out.print("Enter the amout you would like to Deposit: R");
                        depositAmount = depAmount.nextDouble();

                        System.out.print("Your Current Balance = R " + accountService.deposit(depositAmount));
                    } else if (optS == 'W') {
                        Scanner withAmt = new Scanner(System.in);

                        System.out.print("Enter the amount to Withdraw: R");
                        depositAmount = withAmt.nextDouble();

                        accountService.withdraw(depositAmount);
                        System.out.print("Withdraw Successfully\nYour Current Balance is R " + accountService.getBalance());
                    } else if (optS == 'C') {
                        System.out.print("Your Current Balance is = R " + accountService.getBalance());
                    }
                    System.out.print("\nWould you like to perform another accountService?(Y/N): ");
                    cont = scanner.next().charAt(0);
                }
                break;
            default:
                System.out.print("Account Type doesn't exist");
        }
    }
}
