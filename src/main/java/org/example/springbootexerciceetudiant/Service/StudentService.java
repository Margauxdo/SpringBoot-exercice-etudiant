package org.example.springbootexerciceetudiant.Service;

import org.example.springbootexerciceetudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final Map<Integer, Student> students;
    public StudentService() {
        students = new HashMap<>();

        Student student1 = Student.builder()
                .id(1)
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .email("johndoe@gmail.com")
                .build();

        Student student2 = Student.builder()
                .id(2)
                .firstName("marie")
                .lastName("Louis")
                .age(35)
                .email("m-l@gmail.com")
                .build();

        Student student3 = Student.builder()
                .id(3)
                .firstName("louis")
                .lastName("Bertrand")
                .age(15)
                .email("loulou@gmail.com")
                .build();

        students.put(1, student1);
        students.put(2, student2);
        students.put(3, student3);
    }
    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }
    public Student getStudentByName(String lastName){
        return students.values().stream().filter(s -> s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

}
