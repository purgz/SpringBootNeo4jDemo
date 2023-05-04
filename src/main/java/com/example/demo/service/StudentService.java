package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Student;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.CreateStudentRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository){
        this.studentRepository=studentRepository;
        this.departmentRepository=departmentRepository;
    }


    public Student createStudent(CreateStudentRequest createStudentRequest, String departmentName){


        Department department = departmentRepository.findByName(departmentName);
        if(department==null){
            department=new Department();
            department.setName(departmentName);
            departmentRepository.save(department);
        }

        Student student = new Student();
        student.setName(createStudentRequest.getName());
        student.setBirthYear(createStudentRequest.getBirthYear());
        student.setDepartment(department);

        return studentRepository.save(student);
    }

    public String deleteStudent(long id){

        studentRepository.deleteById(id);
        return "Delete student";
    }

    public List<Student> readAllStudents(){
        List<Student> students = new ArrayList<>();
        students = studentRepository.findAll();
        return students;
    }
}
