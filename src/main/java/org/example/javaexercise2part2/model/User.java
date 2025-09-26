package org.example.javaexercise2part2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private int age;

    public User(String username, String password, String email, int age){
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }
    public User(String username, int age){
        this.username = username;
        this.age = age;
    }


}
