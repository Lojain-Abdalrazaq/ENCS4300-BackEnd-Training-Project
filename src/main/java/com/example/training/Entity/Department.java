package com.example.training.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "department_code")
    private String departmentCode;
    @Column(name = "department_description")
    private String departmentDescription;
    // relationship between Department-Teacher
    @OneToMany (mappedBy = "department")
    private List<Teacher> teachers;
    // relationship between Department-Course
    @OneToMany (mappedBy = "department")
    private List<Course> courses;

}
