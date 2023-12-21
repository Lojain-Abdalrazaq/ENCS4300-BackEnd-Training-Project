package com.example.training.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Department name is mandatory")
    @Column(name = "department_name")
    private String departmentName;

    @NotBlank(message = "Department code is mandatory")
    @Column(name = "department_code")
    private String departmentCode;

    @NotBlank(message = "Department description is mandatory")
    @Column(name = "department_description")
    private String departmentDescription;

    /* Relationship */
    // relationship between Department-Teacher
    @OneToMany (mappedBy = "department")
    private List<Teacher> teachers;
    // relationship between Department-Course
    @OneToMany (mappedBy = "department")
    private List<Course> courses;

}
