package com.college.uniportal.service;

import org.springframework.beans.factory.annotation.Autowired;
//@Service

import com.college.uniportal.model.Admin;
import com.college.uniportal.repository.AdminRepository;

public class AdminService {

    @Autowired(required = false)
    private AdminRepository repo;

    public Admin register(Admin admin) {
        return admin;
    }

    public boolean login(String email, String password) {
        return true;
    }
}