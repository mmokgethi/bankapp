package com.bbd.modisa.client;

import com.bbd.modisa.Data.TransactionLog;
import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.AccountType;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.ChequeAccountService;
import com.bbd.modisa.service.SavingsAccountService;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static AccountType acctType;
    private static char accType;

    private static void chequeSavings()
    {
        char cont = 'Y';
        Double amount;

        createAccountService(accType);
        AccountService accountServices = createAccountService(accType);
        TransactionLog myLog = new TransactionLog();

        Account saving = accountServices.createAccount(1);
        System.out.println(saving.getAccountType() + " Account Created Successfully" + saving+ "\n");

        while (cont == 'Y') {
            System.out.print("Which Action would you like to perform in your " + saving.getAccountType() +
                    " Account? Deposit(D)/Withdrawal(W)/Check Balance(C)/Transaction Log(L): ");
            char optS = scanner.next().charAt(0);
            if (optS == 'D') {
                Scanner depAmount = new Scanner(System.in);

                System.out.print("Enter the amount you would like to Deposit: R");
                amount = depAmount.nextDouble();

                System.out.print("Your Current Balance = R " + String.format("%.2f",accountServices.deposit(amount)));
            } else if (optS == 'W') {
                Scanner withAmt = new Scanner(System.in);

                System.out.print("Enter the amount to Withdraw: R");
                amount = withAmt.nextDouble();

                accountServices.withdraw(amount);
                System.out.print("Withdraw Successfully\nYour Current Balance is R " +
                        String.format("%.2f",accountServices.getBalance()));
            } else if (optS == 'C') {
                System.out.print("Your Current Balance is = R " + String.format("%.2f",  accountServices.getBalance()));
            } else if (optS == 'L') {
                myLog.getTranLog();
            }
            System.out.print("\nWould you like to perform another accountService?(Y/N): ");
            cont = scanner.next().charAt(0);
        }
    }


    public static void main(String[] args) {

        System.out.print("What type of account would you like to create? Cheque(C)/Savings(S): ");
        accType = scanner.next().charAt(0);

        chequeSavings();
    }

    private static AccountService createAccountService(char accType)
    {
        if (accType == 'S')
            acctType = AccountType.Savings;
        else if (accType == 'C')
            acctType = AccountType.Cheque;
        else
            throw new AccountNotFoundException("Invalid Account");
        return acctType == AccountType.Cheque ? new ChequeAccountService() :  new SavingsAccountService() ;
    }
}
