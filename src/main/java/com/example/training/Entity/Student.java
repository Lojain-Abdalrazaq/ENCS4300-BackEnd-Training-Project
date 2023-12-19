package com.example.training.Entity;

import com.example.training.Entity.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_bd")
    private Date studentBD;
    @Column(name = "student_gpa")
    private double studentGPA;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_phone")
    private String studentPhone;
    @Column(name = "student_address")
    private String studentAddress;
    @ManyToMany
    @JoinTable(
            name = "enrolled_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> enrolledCourses;
}