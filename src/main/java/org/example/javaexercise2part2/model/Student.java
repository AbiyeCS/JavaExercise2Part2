package org.example.javaexercise2part2.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor // A No argsConstructuor basically just adds a constuctor with no arguments
public class Student {
    public Student(String name, String email, int grade){
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private int grade;
}
