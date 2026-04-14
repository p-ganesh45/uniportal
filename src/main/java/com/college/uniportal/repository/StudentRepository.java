package com.college.uniportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.uniportal.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsn(String usn);
}