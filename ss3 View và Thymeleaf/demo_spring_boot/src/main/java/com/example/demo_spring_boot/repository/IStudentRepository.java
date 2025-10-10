package com.example.demo_spring_boot.repository;

import com.example.demo_spring_boot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findStudentByNameContaining(String searchName);

    Page<Student> findStudentByNameContaining(String searchName, Pageable pageable);

    @Query(value = "select * from students where name like concat('%',:searchName,'%');",nativeQuery = true)
    List<Student> searchByName(@Param("searchName") String searchName);
}
