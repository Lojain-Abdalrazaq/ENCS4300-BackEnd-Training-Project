package com.example.training.Service.Interface;

import com.example.training.Service.DTO.CourseDto;

import java.util.List;

public interface CourseService {
    public CourseDto createCourse(CourseDto courseDto);
    public CourseDto getCourseById(long id);
    public CourseDto updateCourse(long courseId, CourseDto updatedCourse);
    public void deleteCourse(long courseId);
    public List<CourseDto> getAllCourses();
}
