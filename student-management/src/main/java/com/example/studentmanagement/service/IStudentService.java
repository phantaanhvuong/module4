package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStudentService {
    Page<Student> search(String name, String nameType , Pageable pageable);
    void add(Student student);
    Optional<Student> findById(Long id);
    void deleteById(Long id);
    void edit(Student product,Long id);
}
