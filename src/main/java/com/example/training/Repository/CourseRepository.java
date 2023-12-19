package com.example.training.Repository;

import com.example.training.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

        Course save(Course course);
        Optional<Course> findById(Long courseId);
        void deleteById(Long courseId);
        List<Course> findAll();
}
