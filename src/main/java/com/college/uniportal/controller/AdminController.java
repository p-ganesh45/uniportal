package com.college.uniportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.college.uniportal.model.Admin;
import com.college.uniportal.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService service;

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        boolean success = service.login(admin.getEmail(), admin.getPassword());

        if (success) {
            return "Success";
        } else {
            return "Invalid";
        }
    }

    // REGISTER (use once in Postman)
    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return service.register(admin);
    }
}