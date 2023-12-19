package com.example.training.Repository;

import com.example.training.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

    Teacher save(Teacher teacher);
    Optional<Teacher> findById(Long teacherId);
    void deleteById(Long teacherId);
    List<Teacher> findAll();
}
