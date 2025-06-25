package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findBlogsByCategory_NameContainingAndTieuDeContaining(String categoryName, String tieuDe,Pageable pageable);
    List<Blog> findByCategory_Id(int id);

}
