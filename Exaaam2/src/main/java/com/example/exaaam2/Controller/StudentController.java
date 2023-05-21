package com.example.exaaam2.Controller;

import com.example.exaaam2.ApiResponse.ApiResponse;
import com.example.exaaam2.Model.Student;
import com.example.exaaam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ArrayList<Student> getStudent(){
        ArrayList<Student> student=studentService.getStudent();
        return student;
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid Student student,Errors error){
        if(error.hasErrors()){
            String msg=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid Student student,Errors error ,@PathVariable int id) {
        if (error.hasErrors()) {
            String msg = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        boolean isUpdated = studentService.updateStudent(student, id);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        boolean isdeleted = studentService.deleteStudent(id);
        if (isdeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("student Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }
@PutMapping("returnstudent/{id}")
    public ResponseEntity<ApiResponse> returnStudent(Errors error,@PathVariable String name){
        boolean isretuend= studentService.returnStudent(name);
        if(isretuend){
        return ResponseEntity.status(200).body(new ApiResponse(name));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }
}
