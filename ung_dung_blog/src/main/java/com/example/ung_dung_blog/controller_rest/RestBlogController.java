package com.example.ung_dung_blog.controller_rest;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204 thành công không trả về giá trị
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);//200
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getAll(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404 không tìm thấy

        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
        blogService.addOrUpdate(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);//201 thêm thành công
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody Blog blog){
        Blog blog1 = blogService.findById(id);
        if (blog1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blog,blog1);
        blog1.setId(id);
        blogService.addOrUpdate(blog1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204 thành công nhưng không trả về giá trị
    }


}
