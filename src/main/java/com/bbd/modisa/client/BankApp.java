package com.bbd.modisa.client;

import com.bbd.modisa.data.AccountDB;
import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.model.*;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.ChequeAccountService;
import com.bbd.modisa.service.SavingsAccountService;

import java.util.EnumMap;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static char accType;
    private static Double amount;
    private static int accountNo = 0;
    public static EnumMap<AccountType, AccountService> tranMap = new EnumMap<>(AccountType.class);

    private static void chequeSavings()
    {
        accountNo++;
        char cont = 'Y';
        createAccountService(accType);
        AccountService accountServices = createAccountService(accType);

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
                /*for (int i = 0; i < account.getTransactions(1).size(); i++)
                {
                    Transaction myLog = account.getTransactions(1).get(i);
                    System.out.println(myLog);
                }*/
                log();
            }
            System.out.print("\nWould you like to perform another accountService?(Y/N): ");
            cont = scanner.next().charAt(0);
        }
    }

    public static void  services()
    {
        tranMap.put(AccountType.Savings, SavingsAccountService.getSavingsAccountService());
        tranMap.put(AccountType.Cheque, ChequeAccountService.getChequeAccountService());
    }

    public static void deposit()
    {
        Scanner depAmount = new Scanner(System.in);

        System.out.print("Enter the amount you would like to Deposit: R");
        amount = depAmount.nextDouble();
    }

    public static void main(String[] args) {

        System.out.print("What type of account would you like to create? Cheque(C)/Savings(S): ");
        accType = scanner.next().charAt(0);

        chequeSavings();
    }

    private static void withdrawal()
    {
        Scanner withAmt = new Scanner(System.in);

        System.out.print("Enter the amount to Withdraw: R");
        amount = withAmt.nextDouble();
    }

    private static void log()
    {
        services();

        System.out.print("How would you like to sort your Log? From High(H)/From Low(L): ");
        char opt = scanner.next().charAt(0);
        if (opt == 'H')
        {
            SavingsAccountService savingsAccountService = (SavingsAccountService) tranMap.get(AccountType.Savings);

            savingsAccountService.getAllTransactionSort();
        }
        else if (opt == 'L')
        {
            System.out.print("Enter transaction id you would like to retrieve: ");
            int tranId = scanner.nextInt();

            System.out.println(AccountDB.getAccountTransaction(accountNo, tranId));
        }
    }

    private static AccountService createAccountService(char accType)
    {
        /*tranMap.put(AccountType.Cheque, SavingsAccountService.getSavingsAccountService());
        tranMap.put(AccountType.Savings, SavingsAccountService.getSavingsAccountService());*/

        services();
        AccountType acctType;

        if (accType == 'S')
            acctType = AccountType.Savings;
        else if (accType == 'C')
            acctType = AccountType.Cheque;
        else
            throw new AccountNotFoundException("Invalid Account");
        return acctType == AccountType.Cheque ? tranMap.get(AccountType.Cheque) :  tranMap.get(AccountType.Savings);
    }
}
