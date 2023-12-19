package com.example.training.Serivce;

import com.example.training.Serivce.DTO.CourseDto;

import java.util.List;

public interface CourseService {
    public CourseDto createCourse(CourseDto courseDto);
    public CourseDto getCourseById(long id);
    public CourseDto updateCourse(long courseId, CourseDto updatedCourse);
    public void deleteCourse(long courseId);
    public List<CourseDto> getAllCourses();
}
