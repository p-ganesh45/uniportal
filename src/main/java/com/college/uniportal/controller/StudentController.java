package com.college.uniportal.controller;

import com.college.uniportal.model.Student;
import com.college.uniportal.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    // ✅ GET STUDENT
@GetMapping("/student/{usn}")
public ResponseEntity<?> getStudent(@PathVariable String usn) {

    Student s = service.getByUsn(usn);

    if (s == null) {
        return ResponseEntity
                .status(404)
                .body("Student not found");
    }

    return ResponseEntity.ok(s);
}
    // ✅ LOGIN / REGISTER
    @PostMapping("/student/login")
    public Student login(@RequestBody Student s) {
        return service.loginOrRegister(s);
    }

    // ✅ UPDATE
    @PutMapping("/student/update")
    public Student update(@RequestBody Student s) {
        return service.update(s);
    }
}