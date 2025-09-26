package org.example.javaexercise2part2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {
    private int balance;
    private final String accountHolder;

    public BankAccount(int balance, String accountHolder){
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    public void deposit(int amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Balance updated, new balance: "+balance);
        } else {
            System.out.println("Can not deposit an amount less than or equal to 0");
        }
    }

    public void subtract(int amount){
        if (amount > 0 && balance > 0){
            balance -= amount;
            System.out.println("Balance updated, new balance: "+balance);
        } else {
            System.out.println("Sorry balance could not be updated, please try again");
        }
    }
}
