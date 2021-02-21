package com.kvks.demo.service;

import com.kvks.demo.repository.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvks.demo.model.Student.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        List<Student> lstStudents = studentRepository.findAll();
        return lstStudents;
    }

    public Student getStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public Student createStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public Student updateStudent(Student student){
        Optional<Student> foundStudent = studentRepository.findById(student.getId());
        foundStudent.get().setName(student.getName());
        Student updatedStudent = studentRepository.save(foundStudent.get());
        return updatedStudent;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
