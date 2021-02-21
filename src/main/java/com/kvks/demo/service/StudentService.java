package com.kvks.demo.service;

import com.kvks.demo.model.Student.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudent(Long id);

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long id);
}
