package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

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
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }
}
