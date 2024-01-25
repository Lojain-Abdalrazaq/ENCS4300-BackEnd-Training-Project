package com.example.training.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @NotBlank(message = "Course Code is mandatory")
    @Column(name = "course_code")
    private String courseCode;

    @NotBlank(message = "Course Name is mandatory")
    @Column(name = "course_name")
    private String courseName;

    @NotBlank(message = "Course Description is mandatory")
    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "course_prerequisite")
    private String coursePrerequisite;

    @Min(value = 1, message = "Course Credit must be greater than 0")
    @Max(value = 4, message = "Course Credit must be less than 6")
    @Column(name = "course_credit")
    private int courseCredit;

    /* Relationship */
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
