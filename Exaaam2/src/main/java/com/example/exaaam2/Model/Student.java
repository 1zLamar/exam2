package com.example.exaaam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    @NotEmpty(message = "name shouldn't be empty")
    private String name;

    @NotNull(message = "id shouldn't be empty")
    private int id;

    @NotNull(message = "age shouldn't be empty")
    private int age;
    @NotEmpty(message = "major shouldn't be empty")
    private String major;

}
