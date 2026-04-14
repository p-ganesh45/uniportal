package com.college.uniportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.uniportal.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}