package com.example.ungdungmuonsachaop.repository;

import com.example.ungdungmuonsachaop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IBookRepository extends JpaRepository<Book, Long> {
}
