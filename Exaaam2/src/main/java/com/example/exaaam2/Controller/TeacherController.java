package com.example.exaaam2.Controller;

import com.example.exaaam2.ApiResponse.ApiResponse;
import com.example.exaaam2.Model.Student;
import com.example.exaaam2.Model.Teacher;
import com.example.exaaam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/v1/teacher")
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList<Student> getTeacher(){
        ArrayList<Student> student=teacherService.getTeacher();
        return student;
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid Teacher teacher, Errors error){
        if(error.hasErrors()){
            String msg=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid Teacher teacher,Errors error ,@PathVariable int id) {
        if (error.hasErrors()) {
            String msg = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(msg));
        }
        boolean isUpdated = teacherService.updateTeacher(teacher, id);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {
        boolean isdeleted = teacherService.deleteTeacher(id);
        if (isdeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("teacher Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }

    @PutMapping("returnteacher/{id}")
    public ResponseEntity<ApiResponse> returnTeacher(Errors error, @PathVariable int id,String name){
        boolean isretuend= teacherService.returnTeacher(id);
        if(isretuend){
            return ResponseEntity.status(200).body(new ApiResponse(name));
        }
        return ResponseEntity.status(400).body(new ApiResponse("wrong id"));
    }
    }


