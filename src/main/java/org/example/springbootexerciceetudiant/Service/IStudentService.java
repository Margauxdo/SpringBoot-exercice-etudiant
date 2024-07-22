package org.example.springbootexerciceetudiant.Service;

import org.example.springbootexerciceetudiant.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student getStudentByName(String lastName);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(int id);
}
