package br.com.vpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vpayroll.dto.employee.EmployeeRequest;
import br.com.vpayroll.dto.employee.EmployeeResponse;
import br.com.vpayroll.exceptions.EmployeeException;
import br.com.vpayroll.model.Employee;
import br.com.vpayroll.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public EmployeeResponse registerEmployee(EmployeeRequest employeeRequest){

        Employee employee = new EmployeeRequest(employeeRequest.name(), employeeRequest.office(),employeeRequest.scale(), employeeRequest.workedHours()).convert(employeeRequest);

        if(employeeRepository.findByName(employee.getName()) != null){
            throw new EmployeeException
            ("Funcionário já cadastrado.");
        } else{
            employeeRepository.save(employee);
            EmployeeResponse employeeResponse = new EmployeeResponse(employee.getId(), employee.getName(), employee.getOffice(), employee.getScale(), employee.getWorkedHours(), employee.getComments());
            return employeeResponse;
        }
    }
    
}
