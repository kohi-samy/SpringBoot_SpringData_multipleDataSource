package com.kvks.demo.service;

import com.kvks.demo.model.Course.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course getCourse(Long id);

    Course createCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(Long id);
}
