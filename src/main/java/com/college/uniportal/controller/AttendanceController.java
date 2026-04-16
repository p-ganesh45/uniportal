package com.college.uniportal.controller;

import com.college.uniportal.model.Attendance;
import com.college.uniportal.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceRepository repo;

    // ✅ FIXED METHOD
    @PostMapping
    public Attendance add(@RequestBody Attendance a) {
        return repo.save(a);
    }

    @GetMapping("/student/{usn}")
    public List<Attendance> getByUsn(@PathVariable String usn) {
        return repo.findByUsn(usn);
    }
    @PutMapping("/{id}")
    public Attendance update(@PathVariable Long id, @RequestBody Attendance a) {
        Attendance ex = repo.findById(id).orElseThrow();

        ex.setSubject(a.getSubject());
        ex.setPercentage(a.getPercentage());
        ex.setDate(a.getDate());

        return repo.save(ex);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}