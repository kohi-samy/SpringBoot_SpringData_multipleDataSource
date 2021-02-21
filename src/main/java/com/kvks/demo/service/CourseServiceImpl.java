package com.kvks.demo.service;

import com.kvks.demo.model.Course.Course;
import com.kvks.demo.repository.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(){
        List<Course> lstCourses = courseRepository.findAll();
        return lstCourses;
    }

    public Course getCourse(Long id){
        Optional<Course> course = courseRepository.findById(id);
        return course.get();
    }

    public Course createCourse(Course course){
        Course savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    public Course updateCourse(Course course){
        Optional<Course> foundCourse = courseRepository.findById(course.getId());
        foundCourse.get().setName(course.getName());
        Course updatedCourse = courseRepository.save(foundCourse.get());
        return updatedCourse;
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
