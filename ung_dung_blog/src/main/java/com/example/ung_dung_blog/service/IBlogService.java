package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void addOrUpdate(Blog blog);
    Blog findById(int id);
    void remove(int id);

}
