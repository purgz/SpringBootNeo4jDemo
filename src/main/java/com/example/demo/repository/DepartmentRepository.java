package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DepartmentRepository extends Neo4jRepository<Department, Long> {

    Department findByName(String name);
}
