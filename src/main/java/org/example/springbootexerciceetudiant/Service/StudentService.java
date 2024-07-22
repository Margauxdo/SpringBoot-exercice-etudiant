package org.example.springbootexerciceetudiant.Service;

import org.example.springbootexerciceetudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private static int count = 0;

    private final Map<Integer, Student> students;

    public StudentService() {
        students = new HashMap<>();

        Student student1 = Student.builder()
                .id(++count)
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .email("johndoe@gmail.com")
                .build();

        Student student2 = Student.builder()
                .id(++count)
                .firstName("marie")
                .lastName("Louis")
                .age(35)
                .email("m-l@gmail.com")
                .build();

        Student student3 = Student.builder()
                .id(++count)
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
        return students.values().stream().filter(s -> s.getLastName().toUpperCase().contains(lastName.toUpperCase())).findFirst().orElse(null);
    }
    public Student getStudentById(int id) {
        return students.get(id);
    }
    public Student saveStudent(Student student) {
        student.setId(++count);
        students.put(student.getId(), student);
        return student;
    }
    public void deleteStudentById(int id) {
        //Student student = students.get(id);
        students.remove(id);
        //return student;

    }
    public Student updateStudent(Student student) {
        students.put(student.getId(), student);

        return student;
    }

}
