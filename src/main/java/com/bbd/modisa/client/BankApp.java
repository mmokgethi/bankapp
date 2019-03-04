package com.bbd.modisa.client;

//import com.sun.java.util.jar.pack.Instruction;

import com.bbd.modisa.service.CheckAccount;
import com.bbd.modisa.service.SavingsAccount;
import com.bbd.modisa.model.Account;
import com.bbd.modisa.model.AccountType;

import java.util.Scanner;
import java.lang.String;

public class BankApp {
    public static void main(String[] args) {
        //AccountType acctTypeS = AccountType.valueOf("Savings");
        //AccountType acctTypeC = AccountType.valueOf("Cheque");
        Scanner scanner = new Scanner(System.in);
        Double amount = 0D;
        String typeC;
        char accType;

        AccountType acctType;

        //accT.Cheque;
        System.out.print("What type of account would you like to create? Cheque(C)/Savings(S): ");
        accType = scanner.next().charAt(0);
        if (accType == 'C')
            acctType = AccountType.Cheque;
        else //if (accType == 'S')
            acctType = AccountType.Savings;
      /*else
          acctType = AccountType.values();*/

        switch (acctType)
        {
            case Cheque:

                char cont;
                double bal = 0d;
                double cash;

                cont = 'Y';
                Account newAccC = new Account(1, acctType.name());
                CheckAccount cheque = new CheckAccount(1, acctType.name());
                System.out.println(newAccC.getAccountType() + " Account Created Successfully" + newAccC + "\n");

                while (cont == 'Y')
                {


                    System.out.print("Which Action would you like to perform in your " + newAccC.getAccountType() +
                            " Account? Deposit(D)/Withdrawal(W)/Check Balance(C): ");
                    char opt = scanner.next().charAt(0);

                    if (opt == 'D')
                    {
                        System.out.print("Enter the amout you would like to Deposit: R " );
                        Scanner depAmount = new Scanner(System.in);
                        cash = depAmount.nextDouble();
                        System.out.print("Your Current Balance = R " + cheque.deposit(cash));

                    }
                    else if (opt == 'W')
                    {
                        System.out.print("Enter the amount to Withdraw: R" );
                        Scanner withAmt = new Scanner(System.in);
                        cash = withAmt.nextDouble();
                        //cheque.withdraw(cash);
                        System.out.print("Withdraw Successfully\nYour Current Balance is R " + cheque.withdraw(cash));

                    }
                    else if (opt == 'C')
                    {
                        System.out.print("Your Current Balance is = R " + cheque.getBalance());
                    }
                    System.out.print("\nWould you like to perform another transaction?(Y/N): ");
                    cont = scanner.next().charAt(0);
                }
                break;
            case Savings:
                Account newAccS = new Account(1, acctType.name());
                SavingsAccount saving = new SavingsAccount(1, acctType.name());
                System.out.println(newAccS.getAccountType() + " Account Created Successfully" + newAccS + "\n");
                double depositAmount;

                cont = 'Y';

                while (cont == 'Y')
                {
                    System.out.print("Which Action would you like to perform in your " + newAccS.getAccountType() +
                            " Account? Deposit(D)/Withdrawal(W)/Check Balance(C): ");
                    char optS = scanner.next().charAt(0);
                    if (optS == 'D')
                    {
                        Scanner depAmount = new Scanner(System.in);

                        System.out.print("Enter the amout you would like to Deposit: R" );
                        depositAmount = depAmount.nextDouble();

                        System.out.print("Your Current Balance = R " + saving.deposit(depositAmount));
                        //newAccS.deposit();
                    }
                    else if (optS == 'W')
                    {
                        Scanner withAmt = new Scanner(System.in);

                        System.out.print("Enter the amount to Withdraw: R" );
                        depositAmount = withAmt.nextDouble();

                        saving.withdraw(depositAmount);
                        System.out.print("Withdraw Successfully\nYour Current Balance is R " + saving.getBalance());
                    }
                    else if (optS == 'C')
                    {
                        System.out.print("Your Current Balance is = R " + saving.getMyBal());
                    }
                    System.out.print("\nWould you like to perform another transaction?(Y/N): ");
                    cont = scanner.next().charAt(0);
                }
                break;
                default:
                    System.out.print("Account Type doesn't exist");
        }
    }
}
