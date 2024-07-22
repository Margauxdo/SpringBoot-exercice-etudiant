package org.example.springbootexerciceetudiant.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String email;

}
