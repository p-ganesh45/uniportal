package com.college.uniportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.uniportal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByUsn(String usn);
}