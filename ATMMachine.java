package ATMMachine;

import java.util.Scanner;

public class ATMMachine {
    float Balance = 0; // Initialize balance
    int PIN = 1234;

    public void checkpin() {
        System.out.println("Enter your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid pin");
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit money");
        System.out.println("4. EXIT");
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            System.out.println("Thank you for using our ATM. Goodbye!");
            return;
        } else {
            System.out.println("Enter a valid choice");
            menu();
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - amount;
            System.out.println("Money withdrawn successfully");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the Amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money deposited successfully");
        menu();
    }

    public static void main(String[] args) {
        ATMMachine obj = new ATMMachine();
        obj.checkpin();
    }
}