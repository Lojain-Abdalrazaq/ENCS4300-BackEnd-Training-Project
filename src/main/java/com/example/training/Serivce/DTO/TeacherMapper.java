package com.example.training.Serivce.DTO;

import com.example.training.Entity.Department;
import com.example.training.Entity.Teacher;
import com.example.training.Serivce.DTO.TeacherDto;

public class TeacherMapper {
    public static TeacherDto toTeacherDto(Teacher teacher) {
            TeacherDto teacherDto= new TeacherDto();
            teacherDto.setTeacherId(teacher.getTeacherId());
            teacherDto.setTeacherName(teacher.getTeacherName());
            teacherDto.setTeacherGender(teacher.getTeacherGender());
            teacherDto.setTeacherBD(teacher.getTeacherBD());
            teacherDto.setTeacherPhone(teacher.getTeacherPhone());
            teacherDto.setTeacherAddress(teacher.getTeacherAddress());
            teacherDto.setTeacherSalary(teacher.getTeacherSalary());
            teacherDto.setTeacherHourlyRate(teacher.getTeacherHourlyRate());
            teacherDto.setTeacherEmail(teacher.getTeacherEmail());
            teacherDto.setDepartmentId(teacher.getDepartment().getDepartmentId());
            return teacherDto;
    }
    public static Teacher toTeacher(TeacherDto teacherDto, Department department) {
            Teacher teacher= new Teacher();
            teacher.setTeacherId(teacherDto.getTeacherId());
            teacher.setTeacherName(teacherDto.getTeacherName());
            teacher.setTeacherGender(teacherDto.getTeacherGender());
            teacher.setTeacherBD(teacherDto.getTeacherBD());
            teacher.setTeacherPhone(teacherDto.getTeacherPhone());
            teacher.setTeacherAddress(teacherDto.getTeacherAddress());
            teacher.setTeacherSalary(teacherDto.getTeacherSalary());
            teacher.setTeacherHourlyRate(teacherDto.getTeacherHourlyRate());
            teacher.setTeacherEmail(teacherDto.getTeacherEmail());
            teacher.setDepartment(department);
            return teacher;

    }
}
