package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<AppRole,Long> {
    Optional<AppRole> findByName(String name);
}
