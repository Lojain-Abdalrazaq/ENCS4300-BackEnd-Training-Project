package com.example.training.Serivce.DTO;

import com.example.training.Entity.Course;
import com.example.training.Entity.Department;
import com.example.training.Entity.Teacher;
import com.example.training.Serivce.DTO.CourseDto;

public class CourseMapper {
    public static CourseDto toCourseDto(Course course) {

        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseCode(course.getCourseCode());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseDescription(course.getCourseDescription());
        courseDto.setCoursePrerequisite(course.getCoursePrerequisite());
        courseDto.setCourseCredit(course.getCourseCredit());
        courseDto.setDepartmentId(course.getDepartment().getDepartmentId());
        courseDto.setTeacherId(course.getTeacher().getTeacherId());
        return courseDto;
    }
    public static Course toCourse(CourseDto courseDto, Department department, Teacher teacher) {

        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseCode(courseDto.getCourseCode());
        course.setCourseName(courseDto.getCourseName());
        course.setCourseDescription(courseDto.getCourseDescription());
        course.setCoursePrerequisite(courseDto.getCoursePrerequisite());
        course.setCourseCredit(courseDto.getCourseCredit());
        course.setDepartment(department);
        course.setTeacher(teacher);
        return course;
    }
}

