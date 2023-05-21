package com.example.exaaam2.Service;

import com.example.exaaam2.Model.Student;
import com.example.exaaam2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TeacherService {

    ArrayList<Teacher> teachers=new ArrayList<>();

    public ArrayList getTeacher(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(Teacher teacher,int id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.set(id,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.remove(id);
                return true;
            }
        }
        return false;
    }

    public boolean returnTeacher(int id){
        for (int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }

}
