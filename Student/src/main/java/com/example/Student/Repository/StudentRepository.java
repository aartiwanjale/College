package com.example.Student.Repository;


import com.example.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query method to find students by name
    List<Student> findByName(String name);

    // Custom query method to find students by course
    List<Student> findByCourse(String course);

    // Custom query method to find a student by email
    Student findByEmail(String email);
}

