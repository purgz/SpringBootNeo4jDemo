package com.example.demo.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Property(name = "birth_year")
    private int birthYear;
    @Relationship(type = "BELONGS_TO")
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
