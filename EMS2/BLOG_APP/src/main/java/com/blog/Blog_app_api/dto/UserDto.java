package com.blog.Blog_app_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;






public class UserDto {

    private int id;

    @NotNull
    @NotEmpty
    @Size(min=3 , message = "user name must be more than 3")
    private String name;

    @Email(message = "email must be valid")
    private String email;

    @NotNull
    @NotEmpty
//    @Pattern()
    private String password;

    @NotNull
    @NotEmpty
    private String about;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
