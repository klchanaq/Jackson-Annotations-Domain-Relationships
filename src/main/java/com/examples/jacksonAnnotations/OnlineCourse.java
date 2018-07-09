package com.examples.jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

/* Assume a single person registers a bunch of distinct courses*/
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = OnlineCourse.class)
public class OnlineCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    // @JsonIgnoreProperties(value = {"onlineCourses"})
    private Employee employee;

    public OnlineCourse(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public OnlineCourse(Long id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlineCourse that = (OnlineCourse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employee);
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", employee=" + employee +
                '}';
    }
}
