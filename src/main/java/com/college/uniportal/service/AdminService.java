package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.uniportal.model.Admin;
import com.college.uniportal.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public Admin register(Admin admin) {
        return repo.save(admin);
    }

    public boolean login(String email, String password) {
        Admin admin = repo.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }
}