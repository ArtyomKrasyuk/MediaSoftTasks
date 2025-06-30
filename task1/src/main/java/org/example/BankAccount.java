package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BankAccount {
    private String ownersName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    private int number;

    public BankAccount(String ownersName){
        this.ownersName = ownersName;
        this.balance = 1000;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;

        Random random = new Random();
        this.number = random.nextInt(99999999 - 11111111 + 1) + 11111111;
    }

    public boolean deposit(int amount){
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount){
        if(balance >= amount) {
            balance -= amount;
            return true;
        }
        else return false;

    }

    public boolean transfer(BankAccount otherAccount, int amount){
        if(withdraw(amount)){
            otherAccount.deposit(amount);
            return true;
        }
        else return false;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return String.format(
                "Имя владельца: %s, номер аккаунта: %d баланс: %d, дата открытия: %s, заблокирован: %b",
                ownersName,
                number,
                balance,
                openingDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
                isBlocked
        );
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        BankAccount account = (BankAccount) obj;
        return ownersName.equals(account.getOwnersName()) &&
                balance == account.getBalance() &&
                openingDate.isEqual(account.getOpeningDate()) &&
                isBlocked == account.isBlocked() &&
                number == account.getNumber();
    }

    @Override
    public int hashCode(){
        int res = ownersName == null ? 0 : ownersName.hashCode();
        res = 29 * res + balance;
        res = 29 * res + (openingDate == null ? 0 : openingDate.hashCode());
        res = 29 * res + (isBlocked ? 1 : 0);
        res = 29 * res + number;
        return res;
    }
}
