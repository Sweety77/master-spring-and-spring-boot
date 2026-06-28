package com.myproj.springboot.learn_jpa_and_hibernate;

import com.myproj.springboot.learn_jpa_and_hibernate.entity.Course;
import com.myproj.springboot.learn_jpa_and_hibernate.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insertCourse(new Course(102, "Java", "Black book"));
        System.out.println("Course Inserted successfully....");

    }
}
