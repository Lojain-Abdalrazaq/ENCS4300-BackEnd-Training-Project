package com.example.training.Serivce.Interface;

import com.example.training.Serivce.DTO.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long deptId, DepartmentDto departmentDto);
    void deleteDepartment(Long id);
    public List<DepartmentDto> getAllDepartments();
}
