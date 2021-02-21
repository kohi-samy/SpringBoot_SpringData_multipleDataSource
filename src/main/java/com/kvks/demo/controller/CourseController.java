package com.kvks.demo.controller;

import com.kvks.demo.model.Course.Course;
import com.kvks.demo.service.CourseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @GetMapping(value = "/courses/")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> lstCouses = courseServiceImpl.getCourses();
        return new ResponseEntity<>(lstCouses, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "id") Long id){
        Course course = courseServiceImpl.getCourse(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(value = "/courses/")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course savedCourse = courseServiceImpl.createCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.OK);
    }

    @PutMapping(value = "/courses/")
    public ResponseEntity<Course> updateCourses(@RequestBody Course course){
        Course updatedCourse = courseServiceImpl.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(name = "id") Long id){
        courseServiceImpl.deleteCourse(id);
        return new ResponseEntity<>("Course with id:"+ id +" deleted successfully", HttpStatus.OK);
    }
}
