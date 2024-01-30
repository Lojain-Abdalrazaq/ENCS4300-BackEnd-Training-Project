package com.example.training.Service.Interface;

import com.example.training.Service.DTO.TeacherDto;

import java.util.List;

public interface TeacherService {
    public TeacherDto createTeacher(TeacherDto teacherDto);
    public TeacherDto getTeacherById(long id);
    public TeacherDto updateTeacher(long teacherId, TeacherDto updatedTeacher);
    public void deleteTeacher(long teacherId);
    public List<TeacherDto> getAllTeachers();

}
