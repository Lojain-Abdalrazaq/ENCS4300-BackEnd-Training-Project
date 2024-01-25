package com.example.training.Serivce.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

        private Long courseId;
        private String courseCode;
        private String courseName;
        private String courseDescription;
        private String coursePrerequisite;
        private int courseCredit;
        private Long departmentId;  // foreign key for department table
        private Long teacherId;     // foreign key for teacher table

}
