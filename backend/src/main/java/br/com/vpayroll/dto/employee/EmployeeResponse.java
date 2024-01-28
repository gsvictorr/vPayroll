package br.com.vpayroll.dto.employee;

public record EmployeeResponse (Long id, String name, String office, String scale, String workedHours, String comments) {
    
}
