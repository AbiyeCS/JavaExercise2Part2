package org.example.javaexercise2part2.ServiceTest;

import org.example.javaexercise2part2.Service.StudentService;
import org.example.javaexercise2part2.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void shouldReturnAllStudents(){
        // Given - data should already be inserted by @PostConstruct

        // When
        List<Student> students = studentService.returnAllStudents();

        // Then
        assertThat(students.get(0).getName()).isEqualTo("Abz");
    }

    @Test
    void shouldReturnAllStudentsWithGradeAbove60(){
        List<Student> students = studentService.returnAllStudentsAbove60();

        assertThat(students.size()).isEqualTo(2);
    }
}
