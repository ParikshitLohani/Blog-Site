package com.parikshit.blog.service;

import com.parikshit.blog.entity.Blog;

import java.util.List;

public interface BlogService {

    public List<Blog> getAllBlogs();
    public Blog getBlogById(Long id);
    public Blog createBlog(Blog blog);
    public Blog updateBlog(Long id, Blog updatedBlog);
    public void deleteBlog(Long id);
}
