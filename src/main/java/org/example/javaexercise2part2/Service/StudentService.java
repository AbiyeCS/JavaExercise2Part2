package org.example.javaexercise2part2.Service;

import jakarta.annotation.PostConstruct;
import org.example.javaexercise2part2.Repository.StudentRepository;
import org.example.javaexercise2part2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct // Runs after Spring Boot starts
    public void initializeData() {
        // Check if data already exists
        if (studentRepository.count() == 0) {
            List<Student> students = Arrays.asList(
                    new Student("Abz", "Abz@email.com", 75),
                    new Student("Ben", "Ben@email.com", 65),
                    new Student("Charlie", "Charlie@email.com", 45)
            );

            studentRepository.saveAll(students);
            System.out.println("Sample data initialized!");
        }
    }

    public List<Student> returnAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> returnAllStudentsAbove60(){
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getGrade() > 60)
                .toList();
    }
}
