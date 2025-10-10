package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.AClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository <AClass,Long>{
}
