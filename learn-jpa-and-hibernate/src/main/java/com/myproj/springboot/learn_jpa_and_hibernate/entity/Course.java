package com.myproj.springboot.learn_jpa_and_hibernate.entity;

import jakarta.persistence.Entity;

public class Course {

    private int id;
    private String name;
    private String author;

    public Course(String author, int id, String name) {
        this.author = author;
        this.id = id;
        this.name = name;
    }

    public Course() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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
}
