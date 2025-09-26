package org.example.javaexercise2part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void shouldAddTwoNumbers(){
        assertThat(calculator.add(2,3)).isEqualTo(5);
    }

    @Test
    void shouldSubtractTwoNumbers(){
        assertThat(calculator.subtract(10,3)).isEqualTo(7);
    }

    @Test
    void shouldMultiplyTwoNumbers(){
        assertThat(calculator.multiply(10.0,3.0)).isEqualTo(30.0);
    }

    @Test
    void shouldDivideTwoNumbers(){
        assertThat(calculator.divide(6.0,3.0)).isEqualTo(2.0);
    }
}
