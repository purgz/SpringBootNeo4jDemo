package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Student;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.request.UpdateStudentRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Student updateStudent(UpdateStudentRequest updateStudentRequest){

        Optional<Student> student = studentRepository.findById(updateStudentRequest.getId());

        if (student.isPresent()){


            Department department = departmentRepository.findByName(updateStudentRequest.getUpdatedDepartment().getName());
            if(department==null){
                department=new Department();
                department.setName(updateStudentRequest.getUpdatedDepartment().getName());
                departmentRepository.save(department);
            }

            student.get().setDepartment(department);
            student.get().setBirthYear(updateStudentRequest.getUpdatedBirthYear());
            student.get().setName(updateStudentRequest.getUpdatedName());

            return studentRepository.save(student.get());
        }

        return null;
    }
}
