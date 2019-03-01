package com.bbd.modisa;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ask a user to Create Accout

        //System.out.print("What Account would you like to Create?(Check/Savings)");





        Double amount = 0D;

        Account newAcc = new Account(1, 500, "Check ");
        AccountType acctTypeC = AccountType.Cheque;

        System.out.println(newAcc.getAccountType() + "Account Created Successfully" + newAcc + "\n");

        System.out.print("Which Action would you like to perform in your " + newAcc.getAccountType() +
                " Account? Deposit(D)/Withdrawal(W)/Check Balance(C): ");
        char opt = scanner.next().charAt(0);

        if (opt == 'D')
        {
            newAcc.deposit();
        }
        else if (opt == 'W')
        {
            newAcc.withdrawal();
        }
        else if (opt == 'C')
        {
            System.out.print("Your Current Balance is = R " + newAcc.getBalance());
        }
    }
}
