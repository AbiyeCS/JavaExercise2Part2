package org.example.javaexercise2part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp(){
        bankAccount = new BankAccount(1000, "Abz");
    }

    @Test
    void shouldAcceptPositiveDeposit(){
        bankAccount.deposit(500);
        int currentBalance = bankAccount.getBalance();
        assertThat(currentBalance).isEqualTo(1500);
    }

    @Test
    void shouldNotAcceptNegativeDeposit(){
        bankAccount.deposit(-10);
        int currentBalance = bankAccount.getBalance();
        assertThat(currentBalance).isEqualTo(1000);
    }

    @Test
    void shouldBeAbleToSubtract(){
        bankAccount.subtract(500);
        int currentBalance = bankAccount.getBalance();
        assertThat(currentBalance).isEqualTo(500);
    }

    @Test
    void shouldNotBeAbleToSubtract(){
        bankAccount.subtract(-500);
        int currentBalance = bankAccount.getBalance();
        assertThat(currentBalance).isEqualTo(1000);

        bankAccount.subtract(1000);
        bankAccount.subtract(1000);
        currentBalance = bankAccount.getBalance();
        assertThat(currentBalance).isEqualTo(0);
    }
}
