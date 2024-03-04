package com.example.demo.conttoller;

import com.example.demo.dto.Dto;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeService = employeeServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<Dto> create(@RequestBody Dto dto)
    {
        return new  ResponseEntity<>( employeeService.createEmployee(dto), HttpStatus.OK);
    }
    @GetMapping("/searchById/{id}")
    public ResponseEntity<?> searchById(@PathVariable("id") String id)
    {
        return new ResponseEntity<>(employeeService.searchById(id),HttpStatus.OK);
    }
    @GetMapping("searchAll")
    public ResponseEntity<?> searchAll()
    {
        return new ResponseEntity<>(employeeService.searchAll(),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id,@RequestBody Dto dto)
    {
        return new ResponseEntity<>(employeeService.update(id,dto),HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String>delete(@PathVariable String id)
    {
        employeeService.delete(id);
        return new ResponseEntity<>("delete id "+id+" success",HttpStatus.OK);
    }

}
