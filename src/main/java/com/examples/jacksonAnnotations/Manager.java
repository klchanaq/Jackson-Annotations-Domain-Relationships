package com.examples.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",  scope = Manager.class)
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name = "John Thomas";

    // @JsonBackReference
    // @JsonManagedReference
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;

    public Manager(String name) {
        this.name = name;
        employees = new ArrayList<Employee>();
    }

    // Don't do this if do not have a database
    public Manager(long id, String name) {
        this.id = id;
        this.name = name;
        employees = new ArrayList<Employee>();
    }

    public void addEmployees(Employee employee) {
        employees.add(employee);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id &&
                Objects.equals(name, manager.name) &&
                Objects.equals(employees, manager.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employees);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
