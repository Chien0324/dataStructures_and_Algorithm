package org.example;

public class Main2 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("0966906464",700.000);

        account.deposit(300.000);

        account.withdraw(150.000);

        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println("Account Number: " + account.getAccountNumber());
    }
}
