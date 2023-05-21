package com.example.exaaam2.Service;

import com.example.exaaam2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students=new ArrayList<>();

    public ArrayList getStudent(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(Student student,int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(id,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(id);
                return true;
            }
        }
        return false;
    }

    public boolean returnStudent(String name){
        for (int i=0;i<students.size();i++){
            if(students.get(i).getName()==name){
                return true;
            }
        }
        return false;
    }

}
