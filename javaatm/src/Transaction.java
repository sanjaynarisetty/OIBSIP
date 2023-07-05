package javaatm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ATMInterface {
    void withdraw(double amount);
    void deposit(double amount);
    void transfer(double amount);
    void showTransactionHistory();
}

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

class ATM implements ATMInterface {
    private double balance;
    private List<Transaction> transactionHistory;

    public ATM(double initialBalance) {
        balance = initialBalance;
        transactionHistory = new ArrayList<>();
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal is successful. Current balance: Rupees"+" " + balance);
        } else {
            System.out.println("Insufficient funds. Current balance: Rupees"+" " + balance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposit is  successful. Current balance: Rupees"+" " + balance);
    }

    public void transfer(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Transfer", amount));
            System.out.println(" your Transfer is successful. Current balance: Rupees" + balance);
        } else {
            System.out.println("Insufficient funds. Current balance: Rupees"+" " + balance);
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for ( Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + " - Amount: Rupees"+" " + transaction.getAmount());
        }
        System.out.println("Current balance: Rupees" + " " + balance);
    }
}
