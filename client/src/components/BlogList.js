import React from "react";

function BlogList({ onEdit, onDelete , blogs}) {

  return (
    <div className="blog-list">
      <h2>Blog List</h2>
      {blogs.map((blog) => (
        <div key={blog.id} className="blog-item">
          <h3>{blog.title}</h3>
          <p>{blog.content}</p>
          <div className="button-group">
            <button onClick={() => onEdit(blog)} className="edit-button">Edit</button>
            <button onClick={() => onDelete(blog.id)} className="delete-button">Delete</button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default BlogList;
