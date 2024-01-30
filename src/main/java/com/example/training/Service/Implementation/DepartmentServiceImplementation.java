package com.example.training.Service.Implementation;

import com.example.training.Service.Handler.ResourceNotFoundException;
import com.example.training.Service.DTO.DepartmentDto;
import com.example.training.Repository.DepartmentRepository;
import com.example.training.Entity.Department;
import com.example.training.Service.Interface.DepartmentService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public DepartmentDto getDepartmentById(Long id) throws ResourceNotFoundException{
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department with {"+id+"} not found"));
        return modelMapper.map(department, DepartmentDto.class);
    }
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        department = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDto.class);
    }
    @Override
    public DepartmentDto updateDepartment(Long deptId, DepartmentDto departmentDto) throws ResourceNotFoundException {
        Department department = departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Department with {" + deptId + "} not found"));
        if (departmentDto.getDepartmentCode() != null) {
            department.setDepartmentCode(departmentDto.getDepartmentCode());
        }
        if (departmentDto.getDepartmentName() != null) {
            department.setDepartmentName(departmentDto.getDepartmentName());
        }
        if (departmentDto.getDepartmentDescription() != null) {
            department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        }
        department = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDto.class);
    }
    @Override
    public void deleteDepartment(Long id) throws ResourceNotFoundException{
        departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department with {"+id+"+} not found"));
        departmentRepository.deleteById(id);
    }
    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> modelMapper.map(department, DepartmentDto.class))
                .collect(java.util.stream.Collectors.toList());
    }
}
