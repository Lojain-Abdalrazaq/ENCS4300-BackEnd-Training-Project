package com.example.training.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank(message = "Student name cannot be null")
    @Column(name = "student_name")
    private String studentName;

    @Past(message = "Student birthday must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "student_bd")
    private Date studentBD;

    @Min(value = 0, message = "Student GPA must be greater than or equal to 0")
    @Max(value = 4, message = "Student GPA must be less than or equal to 4")
    @Column(name = "student_gpa")
    private Double studentGPA;

    @Email(message = "Student's email must be in the correct format")
    @Column(name = "student_email")
    private String studentEmail;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Student's phone number must be in the correct format")
    @Column(name = "student_phone")
    private String studentPhone;

    @NotBlank(message = "Student address cannot be blank")
    @Column(name = "student_address")
    private String studentAddress;

    /* Relationship */
    @ManyToMany
    @JoinTable(
            name = "enrolled_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> enrolledCourses;
}