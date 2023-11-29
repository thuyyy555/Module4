package com.example.ss7_1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", columnDefinition = "varchar(50)")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Blog> blog;

    public Category() {
    }

    public Category(int categoryId, String categoryName, List<Blog> blog) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blog = blog;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }
}
