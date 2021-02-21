package com.kvks.demo.controller;

import com.kvks.demo.model.Course.Course;
import com.kvks.demo.model.Student.Student;
import com.kvks.demo.service.CourseServiceImpl;
import com.kvks.demo.service.StudentServiceImpl;

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
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

   /* @Autowired
    private CourseServiceImpl courseServiceImpl;*/

   @GetMapping(value = "/students/")
   public ResponseEntity<List<Student>> getStudents(){
       List<Student> lstStudents = studentServiceImpl.getStudents();
       return new ResponseEntity<>(lstStudents, HttpStatus.OK);
   }

   @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Long id){
        Student student = studentServiceImpl.getStudent(id);
       return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/students/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student savedStudent = studentServiceImpl.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }

    @PutMapping(value = "/students/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentServiceImpl.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Long id){
        studentServiceImpl.deleteStudent(id);
        return new ResponseEntity<>("Student with id:"+ id +" deleted successfully", HttpStatus.OK);
    }
/*
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

    @PostMapping(value = "/course/")
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
    }*/
}
