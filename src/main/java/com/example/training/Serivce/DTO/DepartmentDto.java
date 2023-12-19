package com.example.training.Serivce.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
        private Long departmentId;
        private String departmentName;
        private String departmentCode;
        private String departmentDescription;
}
