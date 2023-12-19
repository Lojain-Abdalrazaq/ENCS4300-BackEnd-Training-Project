package com.example.training.Repository;

import com.example.training.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

        Student save(Student student);
        Optional<Student> findById(Long studentId);
        void deleteById(Long studentId);
        List<Student> findAll();
}
