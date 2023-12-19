package com.example.training.Entity;

import com.example.training.Entity.Course;
import com.example.training.Entity.Department;
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
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_gender")
    private String teacherGender;
    @Column(name = "teacher_bd")
    private Date teacherBD;
    @Column(name = "teacher_phone")
    private String teacherPhone;
    @Column(name = "teacher_address")
    private String teacherAddress;
    @Column(name = "teacher_salary")
    private double teacherSalary;
    @Column(name = "teacher_hourly_rate")
    private double teacherHourlyRate;
    @Column(name = "teacher_email")
    private String teacherEmail;
    // relationship between Teacher-Course
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName="department_id")
    private Department department;
    // relationship between Teacher-Course
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
