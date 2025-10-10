package com.example.demo_spring_boot.service;

import com.example.demo_spring_boot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Page<Student> search(String name, Pageable pageable);
    void add (Student student);
    Student findById(int id);
}
