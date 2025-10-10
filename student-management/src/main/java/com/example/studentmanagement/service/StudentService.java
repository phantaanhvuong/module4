package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Page<Student> search(String name, String nameType, Pageable pageable) {
        return studentRepository.search(name,nameType,pageable);
    }

    @Override
    public void add(Student student) {
        if (student.getId() == null || findById(student.getId()).isEmpty()){
            studentRepository.save(student);
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void edit(Student product, Long id) {
        if (findById(id).isPresent()){
            product.setId(id);
            studentRepository.save(product);
        }
    }
}
