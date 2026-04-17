package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.uniportal.model.Student;
import com.college.uniportal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // ✅ LOGIN OR REGISTER
    public Student loginOrRegister(Student s) {

    Student existing = repo.findByUsn(s.getUsn());

    if(existing != null) {
        return existing;
    }

    throw new RuntimeException("Student not found. Please contact admin.");
}

    // ✅ GET STUDENT (NO INSERT HERE)
    public Student getByUsn(String usn){
        return repo.findByUsn(usn);
    }

    // ✅ UPDATE STUDENT
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

    // ✅ CALCULATE YEAR FROM USN
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