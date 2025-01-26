package com.blog.Blog_app_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class  Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer categoryId;

     @Column(name = "title")
    private  String categoryTitle;


     @Column(name = "description")
    private String getCategoryDescription;

     @OneToMany(mappedBy ="category" ,cascade = CascadeType.ALL)
     private List<Post>  posts=new ArrayList<>();








    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getGetCategoryDescription() {
        return getCategoryDescription;
    }

    public void setGetCategoryDescription(String getCategoryDescription) {
        this.getCategoryDescription = getCategoryDescription;
    }
}
