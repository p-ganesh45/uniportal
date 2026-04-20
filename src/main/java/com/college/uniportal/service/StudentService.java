package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.uniportal.model.Student;
import com.college.uniportal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // ✅ LOGIN
    public Student login(Student s) {

        Student existing = repo.findByUsn(s.getUsn());

        if (existing != null &&
            existing.getPassword().equals(s.getPassword())) {
            return existing;
        }

        return null; // important: NO exception
    }

    // ✅ REGISTER
    public Student register(Student s) {

        Student existing = repo.findByUsn(s.getUsn());

        if (existing != null) {
            return null; // already exists
        }

        return repo.save(s);
    }

    // ✅ GET STUDENT
    public Student getByUsn(String usn){
        return repo.findByUsn(usn);
    }

    // ✅ UPDATE
    public Student update(Student s) {

        Student existing = repo.findById(s.getId())
                .orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(s.getName());
        existing.setBranch(s.getBranch());

        if (s.getYear() >= 1 && s.getYear() <= 4) {
            existing.setYear(s.getYear());
        }

        return repo.save(existing);
    }
}