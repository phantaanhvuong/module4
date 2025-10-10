package com.example.demo_spring_boot.service;

import com.example.demo_spring_boot.model.Student;
import com.example.demo_spring_boot.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> search(String name, Pageable pageable) {
        return studentRepository.findStudentByNameContaining(name,pageable);
    }


    @Override
    public void add(Student student) {
        studentRepository.save(student);

    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
