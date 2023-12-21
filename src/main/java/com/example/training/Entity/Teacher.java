package com.example.training.Entity;

import com.example.training.Entity.Course;
import com.example.training.Entity.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank(message = "Teacher name cannot be blank")
    @Column(name = "teacher_name")
    private String teacherName;

    @NotBlank(message = "Teacher gender cannot be blank")
    @Column(name = "teacher_gender")
    private String teacherGender;

    @Past(message = "Teacher birthday must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "teacher_bd")
    private Date teacherBD;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Teacher's phone number must be in the correct format")
    @Column(name = "teacher_phone")
    private String teacherPhone;

    @NotBlank(message = "Student address cannot be blank")
    @Column(name = "teacher_address")
    private String teacherAddress;

    @Min(value = 0, message = "Teacher salary must be greater than or equal to 0")
    @Column(name = "teacher_salary")
    private Double teacherSalary;

    @Column(name = "teacher_hourly_rate")
    private double teacherHourlyRate;

    @Email(message = "Teacher's email must be in the correct format")
    @Column(name = "teacher_email")
    private String teacherEmail;

    /* Relationship */
    // relationship between Teacher-Course
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName="department_id")
    private Department department;
    // relationship between Teacher-Course
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
