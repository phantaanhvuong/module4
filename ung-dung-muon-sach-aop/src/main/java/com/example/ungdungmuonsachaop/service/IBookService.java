package com.example.ungdungmuonsachaop.service;

import com.example.ungdungmuonsachaop.entity.Book;
import com.example.ungdungmuonsachaop.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
}
