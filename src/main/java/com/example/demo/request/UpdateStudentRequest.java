package com.example.demo.request;

import com.example.demo.entity.Department;

public class UpdateStudentRequest {

    private long id;
    private String updatedName;
    private int updatedBirthYear;
    private Department updatedDepartment;

    public String getUpdatedName() {
        return updatedName;
    }

    public int getUpdatedBirthYear() {
        return updatedBirthYear;
    }

    public Department getUpdatedDepartment() {
        return updatedDepartment;
    }

    public long getId(){
        return id;
    }
}
