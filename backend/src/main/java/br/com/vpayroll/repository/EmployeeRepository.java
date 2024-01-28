package br.com.vpayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vpayroll.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Employee findByName(String name);
}
