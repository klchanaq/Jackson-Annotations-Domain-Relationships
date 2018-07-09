package com.examples.jacksonAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.After;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonAnnotationsApplicationTests {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @After
    public void tearDown() throws Exception {
        objectMapper = null;
    }

    @Test
    public void testSerializingWithJsonManagedAndBackReference()
            throws JsonProcessingException {
        Manager manager = new Manager(123L, "Mary Parker");
        Employee employee1 = new Employee(231L, "John Thomas", manager);
        OnlineCourse onlineCourse1 = new OnlineCourse(1001L, "React Complete Guide",  employee1);
        employee1.addOnlineCourse(onlineCourse1);
        OnlineCourse onlineCourse2 = new OnlineCourse(1002L, "Angular 6", employee1);
        employee1.addOnlineCourse(onlineCourse2);
        Employee employee2 = new Employee(232L, "Peter Liang", manager);
        OnlineCourse onlineCourse3 = new OnlineCourse(1003L, "Finaical Modeling II", employee2);
        employee2.addOnlineCourse(onlineCourse3);
        OnlineCourse onlineCourse4 = new OnlineCourse(1004L, "Accounting Level 3",  employee2);
        employee2.addOnlineCourse(onlineCourse4);
        Employee employee3 = new Employee(233L, "Mandy Wong", manager);
        OnlineCourse onlineCourse5 = new OnlineCourse(1005L, "Chemistry II",  employee3);
        employee3.addOnlineCourse(onlineCourse5);
        manager.addEmployees(employee1);
        manager.addEmployees(employee2);
        manager.addEmployees(employee3);

        System.out.println("manager = ");
        System.out.println(manager);

        System.out.println("=====Manager=====");
        System.out.println(objectMapper.writeValueAsString(manager));
        System.out.println();

        System.out.println("=====Employee1=====");
        System.out.println(objectMapper.writeValueAsString(employee1));
        System.out.println();

        System.out.println("=====Employee2=====");
        System.out.println(objectMapper.writeValueAsString(employee2));
        System.out.println();

        System.out.println("=====Employee3=====");
        System.out.println(objectMapper.writeValueAsString(employee3));
        System.out.println();

        System.out.println("=====OnlineCourse1=====");
        System.out.println(objectMapper.writeValueAsString(onlineCourse1));
        System.out.println();

        System.out.println("=====OnlineCourse2=====");
        System.out.println(objectMapper.writeValueAsString(onlineCourse2));
        System.out.println();

        System.out.println("=====OnlineCourse3=====");
        System.out.println(objectMapper.writeValueAsString(onlineCourse3));
        System.out.println();

        System.out.println("=====OnlineCourse4=====");
        System.out.println(objectMapper.writeValueAsString(onlineCourse4));
        System.out.println();

        System.out.println("=====OnlineCourse5=====");
        System.out.println(objectMapper.writeValueAsString(onlineCourse5));
        System.out.println();
    }

}
