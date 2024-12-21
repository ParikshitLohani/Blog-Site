import React, { useState } from "react";
import api from "../api";

function CreateBlog({ onCreate }) {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    api.post("", { title, content }).then(() => {
      setTitle("");
      setContent("");
      onCreate();
    });
  };

  return (
    <form onSubmit={handleSubmit} className="create-blog-form">
      <h2>Create Blog</h2>
      <input
        type="text"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        className="input-field"
      />
      <textarea
        placeholder="Content"
        value={content}
        onChange={(e) => setContent(e.target.value)}
        className="input-field"
      />
      <button type="submit" className="submit-button">Create</button>
    </form>
  );
}

export default CreateBlog;
