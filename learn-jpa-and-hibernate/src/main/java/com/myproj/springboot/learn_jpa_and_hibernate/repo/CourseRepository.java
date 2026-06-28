package com.myproj.springboot.learn_jpa_and_hibernate.repo;

import com.myproj.springboot.learn_jpa_and_hibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class CourseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String INSERT_QUERY =
            """
            insert into course
            (id, name, author)
            values(?,?,?)
            """;

    public void insertCourse(Course course){
        jdbcTemplate.update(INSERT_QUERY,
                            course.getId(),
                            course.getName(),
                            course.getAuthor());
    }

}
