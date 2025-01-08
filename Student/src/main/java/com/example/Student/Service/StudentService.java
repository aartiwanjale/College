package com.example.Student.Service;


import com.example.Student.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    List<Student> getStudentsByName(String name);
    List<Student> getStudentsByCourse(String course);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}

