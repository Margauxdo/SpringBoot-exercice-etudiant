package org.example.springbootexerciceetudiant.model;


import jakarta.validation.constraints.*;
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
    @NotNull(message = " Ce champ doit être rempli")
    @Size(min= 5 , max = 12, message = "il faut 5 caractéres minimum")
    @NotBlank
    private String lastName;
    private String firstName;
   @Min(18)
   @Max(52)
    private int age;
    @NotNull(message = " Ce champ doit être rempli")
    @NotBlank
    @Pattern(regexp = "[\\w]+")
    private String email;

}
