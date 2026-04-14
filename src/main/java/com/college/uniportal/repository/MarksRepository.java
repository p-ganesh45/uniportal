package com.college.uniportal.repository;

import com.college.uniportal.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByUsn(String usn);
}