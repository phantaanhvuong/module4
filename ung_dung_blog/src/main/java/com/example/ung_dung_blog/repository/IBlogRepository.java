package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findBlogsByCategory_NameContainingAndTieuDeContaining(String categoryName, String tieuDe,Pageable pageable);
    List<Blog> findByCategory_Id(int id);
    List<Blog> findByTieuDeContaining(String tieuDe);
    @Query("SELECT b FROM Blog b WHERE " +
            "(:categoryName IS NULL OR :categoryName = '' OR b.category.name LIKE %:categoryName%) AND " +
            "(:tieuDe IS NULL OR b.tieuDe LIKE %:tieuDe%)")
    Page<Blog> search(@Param("categoryName") String categoryName,
                      @Param("tieuDe") String tieuDe,
                      Pageable pageable);


}
