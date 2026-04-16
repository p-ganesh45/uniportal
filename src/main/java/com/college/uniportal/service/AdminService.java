package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@Service

import com.college.uniportal.model.Admin;
import com.college.uniportal.repository.AdminRepository;

public class AdminService {

    @Autowired(required = false)
    private AdminRepository repo;

    @Autowired(required = false)
    private BCryptPasswordEncoder encoder;

    public Admin register(Admin admin) {
        if (repo == null || encoder == null) return admin;

        admin.setPassword(encoder.encode(admin.getPassword()));
        return repo.save(admin);
    }

    public boolean login(String email, String password) {
        if (repo == null || encoder == null) return false;

        Admin admin = repo.findByEmail(email);

        if (admin != null && encoder.matches(password, admin.getPassword())) {
            return true;
        }
        return false;
    }
}