package com.example.training.Serivce.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long studentId;
    private String studentName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date studentBD;
    private Double studentGPA;
    private String studentEmail;
    private String studentPhone;
    private String studentAddress;

}
