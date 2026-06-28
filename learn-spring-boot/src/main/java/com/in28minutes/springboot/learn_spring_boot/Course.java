package com.in28minutes.springboot.learn_spring_boot;

public class Course {

    private int id;
    private String name;
    private String author;

    public Course(int id, String name, String author) {
        this.author = author;
        this.id = id;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
