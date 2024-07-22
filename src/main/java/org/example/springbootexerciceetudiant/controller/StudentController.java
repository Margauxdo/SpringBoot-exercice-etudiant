package org.example.springbootexerciceetudiant.controller;



import org.example.springbootexerciceetudiant.Service.StudentService;
import org.example.springbootexerciceetudiant.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/list")
    public String listStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "listOfStudents";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "registration";
    }




    @GetMapping("/search")
    public String searchStudent(Model model, @RequestParam String lastName){
        Student student = studentService.getStudentByName(lastName);
        if (student != null){
            model.addAttribute("student", student);
            return "detailsOfAStudent";
        }else{
            return "listofStudent";
        }
    }
}
