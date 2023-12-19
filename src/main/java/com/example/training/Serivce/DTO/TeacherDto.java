package com.example.training.Serivce.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    private Long teacherId;
    private String teacherName;
    private String teacherGender;
    private Date teacherBD;
    private String teacherPhone;
    private String teacherAddress;
    private double teacherSalary;
    private double teacherHourlyRate;
    private String teacherEmail;
    private Long departmentId;  // foreign key for department table

}
