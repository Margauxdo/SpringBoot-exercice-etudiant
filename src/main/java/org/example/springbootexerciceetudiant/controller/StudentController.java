package org.example.springbootexerciceetudiant.controller;



import org.example.springbootexerciceetudiant.Service.StudentService;
import org.example.springbootexerciceetudiant.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("studentsList", students);
        return "listOfStudents";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "registration";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);

        return "redirect:/list";
    }




    @GetMapping("/detail/{id}")
    public String detailStudent(@PathVariable("id") int id, Model model){

        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
          return "detailsOfAStudent";
    }
    @PostMapping("/search")
    public String searchStudent(Model model, @RequestParam String lastName){
        Student student = studentService.getStudentByName(lastName);
        System.out.println(student);
        if (student != null){
            model.addAttribute("student", student);
            return "resultSearchAStudent";
        }else{
            return "redirect:/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "registration";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute("student") Student student){

        studentService.updateStudent(student);
        return "redirect:/list";
    }


}
