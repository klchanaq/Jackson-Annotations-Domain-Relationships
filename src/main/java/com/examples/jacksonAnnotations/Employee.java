package com.examples.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Employee.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name = "James Clark";

    // @JsonManagedReference
    // @JsonBackReference
    @ManyToOne
    // @JsonIgnoreProperties(value = {"employees"})
    private Manager manager;

    @OneToMany
    private List<OnlineCourse> onlineCourses;

    // Don't do this if do not have a database
    public Employee(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        this.onlineCourses = new ArrayList<>();
    }

    public Employee(long id, String name, Manager manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.onlineCourses = new ArrayList<>();
    }

    public void addOnlineCourse(OnlineCourse onlineCourse) {
        this.onlineCourses.add(onlineCourse);
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<OnlineCourse> getOnlineCourses() {
        return onlineCourses;
    }

    public void setOnlineCourses(List<OnlineCourse> onlineCourses) {
        this.onlineCourses = onlineCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(manager, employee.manager) &&
                Objects.equals(onlineCourses, employee.onlineCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manager, onlineCourses);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // ", manager=" + manager +
                ", onlineCourses=" + onlineCourses +
                '}';
    }
}