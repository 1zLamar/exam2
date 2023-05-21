package com.example.exaaam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {

    @NotNull(message = "id shouldn't be empty")
    private int id;
    @NotEmpty(message = "name shouldn't be empty")
    private String name;
    @NotEmpty(message = "salary shouldn't be empty")
    private int salary;

}
