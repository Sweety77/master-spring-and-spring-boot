package com.in28minutes.springboot.learn_spring_boot;
// /course
// id, name, author

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {


    private int playGame(String name){
        return 10;
    }


    public String playGame(String name, int score){
        if (playGame(name)==10) return name;
        return "50";
    }

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        System.out.println(playGame("cricket", 500));
        return Arrays.asList(
                new Course(1, "Learn AWS", "int28minutes"),
                new Course(2, "Learn Spring boot", "int28minutes"),
                new Course(3, "Learn DevOps", "int28minutes"),
                new Course(4, "Learn Azure", "int28minutes")
        );


    }
}
