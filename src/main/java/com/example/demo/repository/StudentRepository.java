package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StudentRepository extends Neo4jRepository<Student,Long> {
}
