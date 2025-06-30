package org.example;


public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Артём");
        BankAccount account2 = new BankAccount("Илья");

        System.out.println("Пополнение счёта: " + account1.deposit(1000));
        System.out.println("Снятие денег: " + account1.withdraw(500));
        System.out.println("Снятие денег больше, чем есть на счёте: " + account1.withdraw(100000));
        System.out.println("Перевод: " + account1.transfer(account2, 1500));
        System.out.println("Баланс аккаунта 1: " + account1.getBalance());
        System.out.println("Баланс аккаунта 2: " + account2.getBalance());

        // *
        System.out.println("toString account1:");
        System.out.println(account1);
        System.out.println("Проверка равенства разных аккаунтов: " + account1.equals(account2));
        System.out.println("Проверка равенства одинаковых аккаунтов: " + account1.equals(account1));
    }
}