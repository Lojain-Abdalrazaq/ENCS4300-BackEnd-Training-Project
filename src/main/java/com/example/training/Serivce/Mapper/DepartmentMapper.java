package com.example.training.Serivce.Mapper;

import com.example.training.Entity.Department;
import com.example.training.Serivce.DTO.DepartmentDto;

public class DepartmentMapper {
    public static DepartmentDto toDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        return departmentDto;
    }
    public static Department toDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return department;
    }

}
