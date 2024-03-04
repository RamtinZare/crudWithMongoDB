package com.example.demo.service;

import com.example.demo.dto.Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    Dto createEmployee (Dto dto);

    List<Dto> searchAll();

    ResponseEntity<Dto> searchById (String id);

    Dto update(String id , Dto updatedto);

    void delete(String id);

}
