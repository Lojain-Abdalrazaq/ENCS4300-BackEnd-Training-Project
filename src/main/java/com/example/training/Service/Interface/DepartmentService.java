package com.example.training.Service.Interface;

import com.example.training.Service.DTO.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long deptId, DepartmentDto departmentDto);
    void deleteDepartment(Long id);
    public List<DepartmentDto> getAllDepartments();
}
