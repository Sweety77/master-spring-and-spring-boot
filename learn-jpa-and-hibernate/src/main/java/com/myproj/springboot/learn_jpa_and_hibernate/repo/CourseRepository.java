package com.myproj.springboot.learn_jpa_and_hibernate.repo;

import com.myproj.springboot.learn_jpa_and_hibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class CourseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*private String INSERT_QUERY =
            """
            insert into course
            (id, name, author)
            values(111, 'AWS For Beginner', 'Bob')
            """;*/

    private String INSERT_QUERY =
            """
            insert into course
            (id, name, author)
            values(?,?,?)
            """;

    /*
    jdbcTemplate.update() method is used for insert, update, and delete
         */
    // save course
    public void insertCourse(Course course){
            jdbcTemplate.update(INSERT_QUERY,
                            course.getId(),
                            course.getName(),
                            course.getAuthor());
    }

    public int update(Course course){
        String UPDATE_COURSE = "update course set name=?, author=? where id =?";
        return jdbcTemplate.update(UPDATE_COURSE,
                course.getName(),
                course.getAuthor(),
                course.getId()
                );

    }

    public int deleteByID(int id){
        String DELETE_COURSE = "delete from course where id =?";
        return jdbcTemplate.update(DELETE_COURSE, id);

    }

    public Course fethCourseById(int id){
        String FETCH_BYID = """
                select * from course where id=?
                """;
        return jdbcTemplate.queryForObject(FETCH_BYID, new CourseRowMapper(),id);
    }

    public List<Course> fethAllCourses(){
        String FETCH_All = """
                select * from course
                """;
        return jdbcTemplate.query(FETCH_All, new CourseRowMapper());
    }



}
