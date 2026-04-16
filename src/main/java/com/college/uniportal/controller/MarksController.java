package com.college.uniportal.controller;

import com.college.uniportal.model.Marks;
import com.college.uniportal.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    @Autowired
    private MarksRepository repo;

    // CREATE
    @PostMapping
    public Marks add(@RequestBody Marks m) {
        return repo.save(m);
    }

    // READ
    @GetMapping("/student/{usn}")
    public List<Marks> getByUsn(@PathVariable String usn) {
        return repo.findByUsn(usn);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Marks update(@PathVariable Long id, @RequestBody Marks m) {
        Marks existing = repo.findById(id).orElseThrow();

        existing.setSubject(m.getSubject());
        existing.setScore(m.getScore());
        existing.setDate(m.getDate());

        return repo.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

}