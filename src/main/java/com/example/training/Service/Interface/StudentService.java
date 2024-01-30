package com.example.training.Service.Interface;

import com.example.training.Service.DTO.CourseDto;
import com.example.training.Service.DTO.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto createStudent(StudentDto studentDto);
    public StudentDto getStudentById(long id);
    public StudentDto updateStudent(long studentId, StudentDto updatedStudent);
    public void deleteStudent(long studentId);
    public List<StudentDto> getAllStudents();
    // for the many to many relationship between student and course
    // enrolled_courses table
    void enrollStudentInCourse(Long studentId, Long courseId);
    List<CourseDto> getCoursesForStudent(Long studentId);
}
