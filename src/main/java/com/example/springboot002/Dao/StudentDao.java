package com.example.springboot002.Dao;

import com.example.springboot002.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer,Student> students;

    private String mystring;
    static {
        students = new HashMap<Integer,Student>(){
            {
                put(1,new Student(1,"Wow1","Shit Course1"));
                put(2,new Student(2,"Wow2","Shit Course2"));
                put(3,new Student(3,"Wow3","Shit Course3"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public StudentDao() {
        this.mystring = "This is my String";
    }

    public String getMystring() {
        return mystring;
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student){
        students.put(student.getId(),student);
    }

    public void insertStudent(Student student){
        students.put(student.getId(),student);
    }
}
