package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.uniportal.model.Admin;
import com.college.uniportal.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // Register Admin (run once manually)
    public Admin register(Admin admin) {
        admin.setPassword(encoder.encode(admin.getPassword()));
        return repo.save(admin);
    }

    // Login
    public boolean login(String email, String password) {
        Admin admin = repo.findByEmail(email);

        if (admin != null && encoder.matches(password, admin.getPassword())) {
            return true;
        }
        return false;
    }
}