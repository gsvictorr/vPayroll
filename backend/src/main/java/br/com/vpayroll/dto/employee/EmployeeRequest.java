package br.com.vpayroll.dto.employee;

import org.springframework.beans.BeanUtils;

import br.com.vpayroll.model.Employee;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EmployeeRequest (@NotBlank @NotNull(message = "O nome não pode ser nulo.") @Size(min = 3, max = 60, message = "O nome deve ter pelo menos 3 letras.")String name, 
@NotBlank @NotNull(message = "O cargo não pode ser nulo.") @Size(min = 5, max = 60, message = "O cargo deve ter no mínimo 5 letras") String office,
@NotBlank @NotNull(message = "A escala não pode ser nula.") @Size(min = 3, max = 10, message = "A escala não pode ter menos de 3 letras.")String scale, 
String workedHours){


    public Employee convert(@Valid EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest, employee);
        return employee;
    }
    
}
