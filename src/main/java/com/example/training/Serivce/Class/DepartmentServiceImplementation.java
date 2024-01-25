package com.example.training.Serivce.Class;

import com.example.training.Handler.ResourceNotFoundException;
import com.example.training.Serivce.DTO.DepartmentDto;
import com.example.training.Serivce.Mapper.DepartmentMapper;
import com.example.training.Repository.DepartmentRepository;
import com.example.training.Entity.Department;
import com.example.training.Serivce.Interface.DepartmentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto getDepartmentById(Long id) throws ResourceNotFoundException{
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department with {"+id+"} not found"));
        return DepartmentMapper.toDepartmentDto(department);
    }
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.toDepartment(departmentDto);
        department = departmentRepository.save(department);
        return DepartmentMapper.toDepartmentDto(department);
    }
    @Override
    public DepartmentDto updateDepartment(Long deptId, DepartmentDto departmentDto) throws ResourceNotFoundException{
        Department department = departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Department with {"+deptId+"} not found"));
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department = departmentRepository.save(department);
        return DepartmentMapper.toDepartmentDto(department);
    }
    @Override
    public void deleteDepartment(Long id) throws ResourceNotFoundException{
        departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department with {"+id+"+} not found"));
        departmentRepository.deleteById(id);
    }
    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.toDepartmentDto(department))
                .collect(java.util.stream.Collectors.toList());
    }
}
