package com.example.Student.Service.StudentServiceImpl;


import com.example.Student.Entity.Student;
import com.example.Student.Repository.StudentRepository;
import com.example.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    @Override
    public Student createStudent(Student student) {
        // Additional business logic (if needed) before saving the student
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        // Fetch the existing student
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update the existing student's details
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());

        // Save the updated student
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        // Check if the student exists before deleting
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(existingStudent);
    }
}
