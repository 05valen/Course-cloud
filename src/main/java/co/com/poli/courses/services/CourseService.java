package co.com.poli.courses.services;

import co.com.poli.courses.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course create(Course course);

}
