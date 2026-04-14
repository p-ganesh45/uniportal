package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.uniportal.model.Student;
import com.college.uniportal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student loginOrRegister(Student s) {
        return repo.findByUsn(s.getUsn())
                .orElseGet(() -> {
                    Student newStudent = new Student();
                    newStudent.setUsn(s.getUsn());
                    newStudent.setYear(calculateYear(s.getUsn()));
                    return repo.save(newStudent);
                });
    }

    public Student update(Student s) {
        Student existing = repo.findById(s.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(s.getName());
        existing.setBranch(s.getBranch());

        if (s.getYear() >= 1 && s.getYear() <= 4) {
            existing.setYear(s.getYear());
        }

        return repo.save(existing);
    }

    private int calculateYear(String usn) {
        try {
            int year = Integer.parseInt(usn.substring(3, 5));
            int currentYear = java.time.Year.now().getValue() % 100;
            int diff = currentYear - year + 1;

            if (diff < 1) return 1;
            if (diff > 4) return 4;

            return diff;
        } catch (Exception e) {
            return 1;
        }
    }
}