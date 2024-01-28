package br.com.vpayroll.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "employees")
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String office;
    private String scale;

    // alterar para Duration mais pra frente
    private String workedHours;
    private String comments;

    public Employee (String name, String office, String scale, String workedHours){
        this.name = name;
        this.office = office;
        this.scale = scale;
        this.workedHours = workedHours;
        
    }
    
}
