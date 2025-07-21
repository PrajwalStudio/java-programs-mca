package withdrawdeposit;

import java.io.*;
import java.util.Scanner;

class LessBalException extends Exception {

    double amount;

    LessBalException(double withdrawAmount) {
        amount = withdrawAmount;
    }

    public String toString() {
        return "Rs " + amount + " cannot be withdrawn. Balance should not go below Rs 500.";
    }
}

class Account {

    double cur_bal = 500;

    void deposit(double amount) {
        if (amount < 100) {
            System.out.println("Deposit amount should be minimum Rs 100.");
            return;
        }
        cur_bal += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    void current_balance() {
        System.out.println("Current Balance: Rs " + cur_bal);
    }

    void withdraw(double amount) throws LessBalException {
        if ((cur_bal - amount) < 500) {
            throw new LessBalException(amount);
        } else {
            cur_bal -= amount;
            System.out.println("Withdrawn: Rs " + amount);
        }
    }
}

public class WithdrawDeposit {

    public static void main(String[] args) throws IOException {
        Account a1 = new Account();
        Account a2 = new Account();

        Scanner br = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nChoose Account: \n1. Account 1 \n2. Account 2 \n3. Exit");
            int accChoice = br.nextInt();

            if (accChoice == 3) {
                break;
            }

            System.out.println("Operations:\n1. Deposit\n2. Withdraw\n3. Check Balance");
            System.out.print("Enter choice: ");
            choice = br.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = br.nextDouble();
                    if (accChoice == 1) {
                        a1.deposit(dep);
                    } else {
                        a2.deposit(dep);
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double w = br.nextDouble();
                    try {
                        if (accChoice == 1) {
                            a1.withdraw(w);
                        } else {
                            a2.withdraw(w);
                        }
                    } catch (LessBalException e) {
                        System.out.println("Error: " + e);
                    }
                    break;

                case 3:
                    if (accChoice == 1) {
                        a1.current_balance();
                    } else {
                        a2.current_balance();
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        System.out.println("Thank you!!");
    }
}
