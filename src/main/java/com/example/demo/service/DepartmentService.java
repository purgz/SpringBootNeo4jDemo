package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    public Department getDepartment(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public Iterable<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
