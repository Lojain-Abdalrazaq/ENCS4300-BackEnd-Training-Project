package com.example.training.Repository;

import com.example.training.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

        Department save(Department department);
        Optional<Department> findById(Long departmentId);
        void deleteById(Long departmentId);
        List<Department> findAll();
}
