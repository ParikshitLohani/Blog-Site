package com.parikshit.blog.controller;

import com.parikshit.blog.entity.Blog;
import com.parikshit.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getAllBlogs() {
        System.out.println("call made");
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }
}
