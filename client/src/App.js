import React, { useState, useEffect } from "react";
import BlogList from "./components/BlogList";
import CreateBlog from "./components/CreateBlog";
import api from "./api";

function App() {
  const [trigger, setTrigger] = useState(false);
  const [blogs, setBlogs] = useState([]);

  useEffect(() => {
    api.get("").then((response) => setBlogs(response.data)).catch(err => alert(err?.data?.toString() || err?.toString()));
  }, []);

  const refreshBlogs = () => {
    api.get("").then((response) => setBlogs(response.data)).catch(err => alert(err?.data?.toString() || err?.toString()));
  }

  const handleCreate = () => setTrigger(!trigger);
  const handleEdit = (blog) => {
    const title = prompt("Edit title", blog.title);
    const content = prompt("Edit content", blog.content);
    api.put(`/${blog.id}`, { title, content }).then(() => { setTrigger(!trigger); refreshBlogs(); }).catch(err => alert(err?.data?.toString() || err?.toString()));
  };
  const handleDelete = (id) => {
    api.delete(`/${id}`).then(() => { setTrigger(!trigger); refreshBlogs(); }).catch(err => alert(err?.data?.toString() || err?.toString()));
  };

  return (
    <div className="container">
      <h1>Blog App</h1>
      <CreateBlog onCreate={handleCreate} />
      <BlogList onEdit={handleEdit} onDelete={handleDelete} blogs={blogs} />
    </div>
  );
}

export default App;
