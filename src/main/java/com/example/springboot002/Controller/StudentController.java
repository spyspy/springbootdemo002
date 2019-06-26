package com.example.springboot002.Controller;

import com.example.springboot002.Entity.Student;
import com.example.springboot002.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Locale;

@RestController
@RequestMapping("/students")
public class StudentController {

    /**
     * Exaample: http://localhost:8090/students/string
     *
     *
     * */

    @Autowired
    private StudentService studentService;

    @Autowired
    private MessageSource messageSource;

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

    @RequestMapping(value = "/insert",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> insertStudentById(@RequestBody Student student){
        studentService.insertStudent(student);
        return studentService.getAllStudents();
    }


    @RequestMapping(value = "/string",method=RequestMethod.GET)
    public String wow(){
        return studentService.getDaoString();
    }

    @RequestMapping(value = "/message",method=RequestMethod.GET)
    public String message(){
        //Note: No ok yet.....
        String returnSting = messageSource.getMessage("wow.test",new Object[]{1,2,3}, null);

        return returnSting;
    }

}
