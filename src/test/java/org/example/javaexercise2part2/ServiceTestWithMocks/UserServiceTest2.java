package org.example.javaexercise2part2.ServiceTestWithMocks;

import org.example.javaexercise2part2.Repository.UserRepository;
import org.example.javaexercise2part2.Service.UserService;
import org.example.javaexercise2part2.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

// Made a 2nd one to test out mocking within test
@ExtendWith(MockitoExtension.class)
public class UserServiceTest2 {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;
    // Don't need a BeforeEach if injecting Mocks to Create UserService

    @Test
    void shouldBeAbleToFindByUsername(){
        // GIVEN - Tell the mock what to return
        // Mocks are dumb default you have to tell them what to return!
        User expectedUser = new User("Rio", "Bastion111", "rio.thompson@email.com", 32);
        when(userRepository.findByUsername("Rio")).thenReturn(Optional.of(expectedUser));

        User user = userService.findByUsername("Rio");
        assertThat(user.getPassword()).isEqualTo("Bastion111");
        assertThat(user.getEmail()).isEqualTo("rio.thompson@email.com");
        assertThat(user.getAge()).isEqualTo(32);
    }

    @Test
    void shouldBeAbleToFindByEmail(){
        User expectedUser = new User("Rio", "Bastion111", "rio.thompson@email.com", 32);
        when(userRepository.findByEmail("rio.thompson@email.com")).thenReturn(Optional.of(expectedUser));

        User user = userService.findByEmail("rio.thompson@email.com");
        assertThat(user.getPassword()).isEqualTo("Bastion111");
        assertThat(user.getUsername()).isEqualTo("Rio");
        assertThat(user.getAge()).isEqualTo(32);
    }

//    @Test
//    void shouldBeAbleToFindAllByAgeAfter(){
//        List<User> expectedUsers = Arrays.asList(
//                new User("Abz",27),
//                new User("John", 33),
//                new User("Tim", 31)
//        );
//        when(userRepository.findAllByAgeAfter(30)).thenReturn(expectedUsers);
//
//        List<User> users = userService.findAllByAgeAfter(30);
//        assertThat(users.size()).isEqualTo(2);
//    } This test won't do much for me
}
