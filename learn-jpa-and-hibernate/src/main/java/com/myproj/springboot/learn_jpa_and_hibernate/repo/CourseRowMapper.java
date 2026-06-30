package com.myproj.springboot.learn_jpa_and_hibernate.repo;

import com.myproj.springboot.learn_jpa_and_hibernate.entity.Course;
import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setName(rs.getString("name"));
        course.setAuthor(rs.getString("author"));

        return course;
    }
}
