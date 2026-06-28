package com.myproj.springboot.learn_jpa_and_hibernate.repo;

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
            values(111, 'AWS For Beginner', 'Bob')
            """;

    public void insertCourse(){
        jdbcTemplate.update(INSERT_QUERY);
    }

}
