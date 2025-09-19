package org.example.javaexercise2part2.ServiceTest;

import org.example.javaexercise2part2.Service.UserService;
import org.example.javaexercise2part2.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void shouldBeAbleToFindByUsername(){
        User user = userService.findByUsername("Felix");

        assertThat(user.getEmail()).isEqualTo("felix.anderson@email.com");
        assertThat(user.getPassword()).isEqualTo("Cipher808");

    }

    @Test
    void shouldBeAbleToFindByEmail(){
        User user = userService.findByEmail("ivy.martinez@email.com");

        assertThat(user.getUsername()).isEqualTo("Ivy");
        assertThat(user.getPassword()).isEqualTo("Sentinel222");

    }

    @Test
    void shouldBeAbleToFindAllAbove30(){
        List<User> usersAbove30 = userService.findAllByAgeAfter(30);

        assertThat(usersAbove30.size()).isEqualTo(7);
    }


}
