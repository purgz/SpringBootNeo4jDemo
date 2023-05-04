package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students/create")
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest, @RequestParam String
                                 department){
        return studentService.createStudent(createStudentRequest,department);
    }

    @DeleteMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/students/readAll")
    public List<Student> readAllStudents(){
        return studentService.readAllStudents();
    }


}
