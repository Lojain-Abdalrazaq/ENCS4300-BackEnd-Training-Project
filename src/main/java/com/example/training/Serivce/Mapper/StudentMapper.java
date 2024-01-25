package com.example.training.Serivce.Mapper;

import com.example.training.Entity.Student;
import com.example.training.Serivce.DTO.StudentDto;

public class StudentMapper {
    public static StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentBD(student.getStudentBD());
        studentDto.setStudentGPA(student.getStudentGPA());
        studentDto.setStudentEmail(student.getStudentEmail());
        studentDto.setStudentPhone(student.getStudentPhone());
        studentDto.setStudentAddress(student.getStudentAddress());
        return studentDto;
    }

    public static Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentBD(studentDto.getStudentBD());
        student.setStudentGPA(studentDto.getStudentGPA());
        student.setStudentEmail(studentDto.getStudentEmail());
        student.setStudentPhone(studentDto.getStudentPhone());
        student.setStudentAddress(studentDto.getStudentAddress());
        return student;
    }
}
