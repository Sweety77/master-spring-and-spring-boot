package com.myproj.springboot.learn_jpa_and_hibernate;

import com.myproj.springboot.learn_jpa_and_hibernate.entity.Course;
import com.myproj.springboot.learn_jpa_and_hibernate.repo2.CourseRepositoryNamedParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        prefix = "runner",
        name = "enable-runner",
        havingValue = "ParamJdbcTemplate"
)
public class CourseJdbcCommandLineRunnerNamedParamJdbcTemplate implements CommandLineRunner {

    @Autowired
    private CourseRepositoryNamedParam repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insertCourse(new Course(102, "Java", "Black book"));
        repository.insertCourse(new Course(103, "AWS", "Head first"));
        repository.insertCourse(new Course(104, "Spring", "Spring Book"));
        repository.insertCourse(new Course(105, "Docker", "Docker beginners book"));
        repository.insertCourse(new Course(106, "Kubernetes", "Kubernetes beginners book"));
        repository.insertCourse(new Course(107, "Linux", "Linux Mastery"));
        System.out.println("Course Inserted successfully....");

        int row_updated = repository.update(new Course(104, "Spring Head First", "John Carnell"));
        System.out.println( row_updated +" Record update successfully..");

        int row_deleted = repository.deleteByID(103);
        System.out.println(row_deleted + " Deleted Successfully..");

        System.out.println("102 Course details - "+repository.fethCourseById(102));
        System.out.println("\n All the available course options are: ");

//        System.out.println("Check all the course options available.. \n"+repository.fethAllCourses());

        repository.fethAllCourses().forEach(System.out::println);

        System.out.println("\nFetch all the courses using BeanPropertyRowMapper.. ");
        repository.fethAllCourse().forEach(System.out::println);
    }






}
