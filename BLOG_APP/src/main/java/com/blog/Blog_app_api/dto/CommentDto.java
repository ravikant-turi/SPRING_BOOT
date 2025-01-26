package com.blog.Blog_app_api.dto;


import com.blog.Blog_app_api.entity.Comment;
import lombok.Data;

import java.util.Set;
@Data
public class CommentDto {
    private int id;
    private String content;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
