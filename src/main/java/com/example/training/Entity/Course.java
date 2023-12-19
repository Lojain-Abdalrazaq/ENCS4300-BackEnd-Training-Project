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
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_description")
    private String courseDescription;
    @Column(name = "course_prerequisite")
    private String coursePrerequisite;
    @Column(name = "course_credit")
    private int courseCredit;
    // relationship between Teacher-Course
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName="teacher_id")
    private Teacher teacher;
    // relationship between Department-Course
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName="department_id")
    private Department department;
    // relationship between Course-Student
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Student> students;
}
