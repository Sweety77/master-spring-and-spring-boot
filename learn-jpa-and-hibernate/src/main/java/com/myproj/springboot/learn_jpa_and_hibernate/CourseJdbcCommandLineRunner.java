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
        repository.insertCourse(new Course(103, "AWS", "Head first"));
        repository.insertCourse(new Course(104, "Spring", "Spring Book"));
        repository.insertCourse(new Course(105, "Docker", "Docker beginners book"));
        System.out.println("Course Inserted successfully....");

        int row_updated = repository.update(new Course(104, "Spring Head First", "John Carnell"));
        System.out.println( row_updated +" Record update successfully..");

        int row_deleted = repository.deleteByID(103);
        System.out.println(row_deleted + " Deleted Successfully..");

        System.out.println("102 Course details - "+repository.fethCourseById(102));

//        System.out.println("Check all the course options available.. \n"+repository.fethAllCourses());

        repository.fethAllCourses().forEach(System.out::println);

    }






}
