package com.bbd.modisa.client;

import com.bbd.modisa.data.TransactionLog;
import com.bbd.modisa.exception.AccountNotFoundException;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.AccountType;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.ChequeAccountService;
import com.bbd.modisa.service.SavingsAccountService;
import java.util.Scanner;

public class BankApp {
    private static Scanner scanner = new Scanner(System.in);
    private static char accType;

    private static void chequeSavings()
    {
        char cont = 'Y';
        Double amount;
        TransactionLog tl = new TransactionLog();

        createAccountService(accType);
        AccountService accountServices = createAccountService(accType);

        Account saving = accountServices.createAccount(1);
        System.out.println(saving.getAccountType() + " Account Created Successfully" + saving+ "\n");
        //tl.getAccount(saving.getAccountType());

        while (cont == 'Y') {
            System.out.print("Which Action would you like to perform in your " + saving.getAccountType() +
                    " Account? Deposit(D)/Withdrawal(W)/Check Balance(C)/Transaction Log(L): ");
            char optS = scanner.next().charAt(0);
            if (optS == 'D') {
                Scanner depAmount = new Scanner(System.in);

                System.out.print("Enter the amount you would like to Deposit: R");
                amount = depAmount.nextDouble();
                tl.getDeposit(amount);
                System.out.print("Your Current Balance = R " + String.format("%.2f",accountServices.deposit(amount)));
            } else if (optS == 'W') {
                Scanner withAmt = new Scanner(System.in);

                System.out.print("Enter the amount to Withdraw: R");
                amount = withAmt.nextDouble();

                accountServices.withdraw(amount);
                tl.getWithdraw(amount);
                System.out.print("Withdraw Successfully\nYour Current Balance is R " +
                        String.format("%.2f",accountServices.getBalance()));
            } else if (optS == 'C') {
                System.out.print("Your Current Balance is = R " + String.format("%.2f",  accountServices.getBalance()));
            } else if (optS == 'L') {
                System.out.print("How would you like to sort your Log? From High(H)/From Low(L): ");
                char opt = scanner.next().charAt(0);
                if (opt == 'H')
                    tl.transactions();
                else if (opt == 'L')
                    tl.transactionsR();
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
        AccountType acctType;

        if (accType == 'S')
            acctType = AccountType.Savings;
        else if (accType == 'C')
            acctType = AccountType.Cheque;
        else
            throw new AccountNotFoundException("Invalid Account");
        return acctType == AccountType.Cheque ? new ChequeAccountService() :  new SavingsAccountService() ;
    }
}
