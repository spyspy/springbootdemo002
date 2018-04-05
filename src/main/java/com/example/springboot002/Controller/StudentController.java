package com.example.springboot002.Controller;

import com.example.springboot002.Entity.Student;
import com.example.springboot002.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public Collection<Student> removeStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
        return studentService.getAllStudents();
    }


    @RequestMapping(value = "/update",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> updateStudentById(@RequestBody Student student){
        studentService.updateStudent(student);
        return studentService.getAllStudents();
    }


    @RequestMapping(value = "/string",method=RequestMethod.GET)
    public String wow(){
        return studentService.getDaoString();
    }



}
