package com.example.quanlycauthubongda.repository;

import com.example.quanlycauthubongda.entity.CauThu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICauThuRepository extends JpaRepository<CauThu, Long> {

    @Query("select ct from CauThu ct where "+
            "ct.ten = '' or ct.ten like %:ten%")
    Page<CauThu> search(@Param("ten") String ten, Pageable pageable);
}
