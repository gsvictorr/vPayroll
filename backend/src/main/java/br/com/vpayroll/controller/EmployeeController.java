package br.com.vpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vpayroll.dto.employee.EmployeeRequest;
import br.com.vpayroll.dto.employee.EmployeeResponse;
import br.com.vpayroll.service.EmployeeService;
import br.com.vpayroll.service.exceptions.EmployeeException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;


    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        try {
            EmployeeResponse employeeResponse = employeeService.registerEmployee(employeeRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
        } catch (EmployeeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
