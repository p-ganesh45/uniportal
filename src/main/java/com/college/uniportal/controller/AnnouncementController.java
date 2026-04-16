package com.college.uniportal.controller;

import com.college.uniportal.model.Announcement;
import com.college.uniportal.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/api/announcements")
@CrossOrigin(origins = "*")
public class AnnouncementController {

    @Autowired
    private AnnouncementRepository repo;

    @PostMapping
    public Announcement add(@RequestBody Announcement a) {
        return repo.save(a);
    }

    @GetMapping
    public List<Announcement> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public Announcement update(@PathVariable Long id, @RequestBody Announcement a) {
        Announcement ex = repo.findById(id).orElseThrow();

        ex.setText(a.getText());
        ex.setDate(a.getDate());

        return repo.save(ex);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}