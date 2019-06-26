package com.example.springboot002.Dao;

import com.example.springboot002.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {

    private static Map<Integer,Student> students;

    private String mystring;
    static {
        students = new HashMap<Integer,Student>(){
            {
                put(1,new Student(1,"Wow1","English Course101"));
                put(2,new Student(2,"Wow2","Computer Course202"));
                put(3,new Student(3,"Wow3","Biology Course303"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public StudentDaoImpl() {
        this.mystring = "This is my String Object";
    }

    @Override
    public String getMystring() {
        return mystring;
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        students.put(student.getId(),student);
    }

    @Override
    public void insertStudent(Student student){
        students.put(student.getId(),student);
    }
}
