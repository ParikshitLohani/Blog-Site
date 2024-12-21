package com.parikshit.blog.service;

import com.parikshit.blog.entity.Blog;
import com.parikshit.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            blog.setTitle(updatedBlog.getTitle());
            blog.setContent(updatedBlog.getContent());
            return blogRepository.save(blog);
        }
        return null;
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
