package com.example.demo.service.impl;

import com.example.demo.dto.Dto;
import com.example.demo.entity.Entity;
import com.example.demo.exeption.Exeption;
import com.example.demo.mapper.Mapper;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements com.example.demo.service.EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public ResponseEntity<?> create(Entity entity)
    {
        return new  ResponseEntity<>( employeeRepository.save(entity),HttpStatus.OK);
    }

    @Override
    public Dto createEmployee(Dto dto) {
        Entity entity = Mapper.mapToEmployee(dto);
        Entity saveEmployee= employeeRepository.save(entity);
        return Mapper.mapToDto(saveEmployee);
    }

    @Override
    public List<Dto> searchAll() {
        List<Entity> entities=employeeRepository.findAll();
        return entities.stream().map(Mapper::mapToDto).collect(Collectors.toList());
        //ToDo:stream filter map java8
    }

    @Override
    public ResponseEntity<Dto> searchById(String id) {
        Entity entity = employeeRepository.findById(id).orElseThrow(() ->new Exeption("not found id"+id));
        Dto dto = Mapper.mapToDto(entity);
        ResponseEntity<Dto> dtoResponseEntity = new ResponseEntity<>(dto, HttpStatus.OK);
        return dtoResponseEntity;
    }

    @Override
    public Dto update(String id, Dto updatedto) {
        /*
        List<String> list1=new ArrayList<>();
        List<String> list2=new LinkedList<>();

        list1.add("fgg");
        list2.add("hghjgj");

         */

        Entity entity=employeeRepository.findById(id).orElseThrow(()->new Exeption("not found id"+id));
        entity.setFirstName(updatedto.getFirstName());
        entity.setLastName(updatedto.getLastName());
        entity.setEmail(updatedto.getEmail());
        Entity updateEmployee= employeeRepository.save(entity);
        return Mapper.mapToDto(updateEmployee);
    }

    @Override
    public void delete(String id) {
        Entity entity = employeeRepository.findById(id).orElseThrow(()-> new Exeption("id not found"+id));
        employeeRepository.deleteById(id);
    }

}
