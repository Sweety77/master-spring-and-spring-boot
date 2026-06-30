package com.myproj.springboot.learn_jpa_and_hibernate.repo2;

import com.myproj.springboot.learn_jpa_and_hibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryNamedParam {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private String INSERT_QUERY =
            """
            insert into course
            (id, name, author)
            values(:id, :name, :author)
            """;

    /*
    jdbcTemplate.update() method is used for insert, update, and delete
         */
    // save course
    public void insertCourse(Course course){

    // Map all the parameter to this map and pass with query to the jdbc update method.
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();

        sqlParameterSource.addValue("id", course.getId());
        sqlParameterSource.addValue("name", course.getName());
        sqlParameterSource.addValue("author", course.getAuthor());

        jdbcTemplate.update(INSERT_QUERY, sqlParameterSource);
    }

    public int update(Course course){
        String UPDATE_COURSE = "update course set name=:name, author=:auth where id =:id";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("name", course.getName());
        sqlParameterSource.addValue("id", course.getId());
        sqlParameterSource.addValue("auth", course.getAuthor());

        return jdbcTemplate.update(UPDATE_COURSE, sqlParameterSource);

    }

    public int deleteByID(int id){
        String DELETE_COURSE = "delete from course where id =:id";
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", id);
        return jdbcTemplate.update(DELETE_COURSE, sqlParameterSource);

    }

    public Course fethCourseById(int id){
        String FETCH_BYID = """
                select * from course where id=:id
                """;

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", id);


        return jdbcTemplate.queryForObject(FETCH_BYID, sqlParameterSource, new CourseRowMapper());
    }

    public List<Course> fethAllCourses(){
        String FETCH_All = """
                select * from course
                """;
        return jdbcTemplate.query(FETCH_All, new CourseRowMapper());
    }

    /*
     USE BeanPropertyRowMapper instead of RowMapper<T>
     No need to write a separate class to map DB column to Entity property
     Maps only similar rows, slow compare to traditional RowMapper<T>
     DB - first_name get easily mapped to the Entity property firstName, - under-Score-to camelCase supported by Spring
    */
    public List<Course> fethAllCourse(){
        String FETCH_All = """
                select * from course
                """;
        return jdbcTemplate.query(FETCH_All, new BeanPropertyRowMapper<>(Course.class));
    }



}
