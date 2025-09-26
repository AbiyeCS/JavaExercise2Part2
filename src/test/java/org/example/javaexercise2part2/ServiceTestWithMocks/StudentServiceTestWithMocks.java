package org.example.javaexercise2part2.ServiceTestWithMocks;

import org.example.javaexercise2part2.Repository.StudentRepository;
import org.example.javaexercise2part2.Service.StudentService;
import org.example.javaexercise2part2.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTestWithMocks {
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void shouldReturnAllStudents(){
        List<Student> students = Arrays.asList(
                new Student("Abz", "Abz@email.com", 75),
                new Student("Ben", "Ben@email.com", 65),
                new Student("Charlie", "Charlie@email.com", 45)
        );
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> studentList = studentService.returnAllStudents();
        assertThat(studentList.size()).isEqualTo(3);
    }

    @Test
    void shouldReturnAllStudentsWithAbove60(){
        List<Student> students = Arrays.asList(
                new Student("Abz", "Abz@email.com", 75),
                new Student("Ben", "Ben@email.com", 65),
                new Student("Charlie", "Charlie@email.com", 45)
        );
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> studentList = studentService.returnAllStudentsAbove60();
        assertThat(studentList.size()).isEqualTo(2);
    }
}
