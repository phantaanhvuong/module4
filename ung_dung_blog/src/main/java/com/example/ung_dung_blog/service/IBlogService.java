package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    void addOrUpdate(Blog blog);
    Blog findById(int id);
    void remove(int id);
    Page<Blog> search(String category,String tieuDe, Pageable pageable);
    List<Blog> findByCategory_Id(int id);



}
