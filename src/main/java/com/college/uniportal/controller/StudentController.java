package com.college.uniportal.controller;

import com.college.uniportal.model.Student;
import com.college.uniportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired(required = false)
    private StudentService service;

    @GetMapping("/student/{usn}")
    public Student getStudent(@PathVariable String usn) {

        if (service == null) return null;

        Student s = new Student();
        s.setUsn(usn);
        return service.loginOrRegister(s);
    }

    @PostMapping("/student/login")
    public Student login(@RequestBody Student s) {

        if (service == null) return s;

        return service.loginOrRegister(s);
    }

    @PutMapping("/student/update")
    public Student update(@RequestBody Student s) {

        if (service == null) return s;

        return service.update(s);
    }
}