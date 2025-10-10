package com.example.studentmanagement.repository;
import com.example.studentmanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
    @Query("select c from Student c where "+
    "(c.name = '' or c.name like concat('%',:name,'%'))"+
    "and (c.studentClass.name = '' or c.studentClass.name like concat('%',:nameClass,'%') )")
    Page<Student> search(@Param("name") String name,
                         @Param("nameClass")String nameClass,
                         Pageable pageable);
}
