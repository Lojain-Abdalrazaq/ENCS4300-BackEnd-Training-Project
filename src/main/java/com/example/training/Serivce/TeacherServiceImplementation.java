package com.example.training.Serivce;

import com.example.training.Entity.Department;
import com.example.training.ResourceNotFoundException;
import com.example.training.Entity.Teacher;
import com.example.training.Repository.TeacherRepository;
import com.example.training.Repository.DepartmentRepository;
import com.example.training.Serivce.DTO.TeacherDto;
import com.example.training.Serivce.DTO.TeacherMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class TeacherServiceImplementation implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Department department = departmentRepository.findById(teacherDto.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department with {id} not found"+ teacherDto.getDepartmentId()));
        Teacher teacher = TeacherMapper.toTeacher(teacherDto, department);
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.toTeacherDto(teacher);
    }
    @Override
    public TeacherDto getTeacherById(long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher with {id} not found"+ id));
        return TeacherMapper.toTeacherDto(teacher);
    }
    @Override
    public TeacherDto updateTeacher(long teacherId, TeacherDto updatedTeacher) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher with {id} not found"+ teacherId));
        teacher.setTeacherName(updatedTeacher.getTeacherName());
        teacher.setTeacherGender(updatedTeacher.getTeacherGender());
        teacher.setTeacherBD(updatedTeacher.getTeacherBD());
        teacher.setTeacherPhone(updatedTeacher.getTeacherPhone());
        teacher.setTeacherAddress(updatedTeacher.getTeacherAddress());
        teacher.setTeacherSalary(updatedTeacher.getTeacherSalary());
        teacher.setTeacherHourlyRate(updatedTeacher.getTeacherHourlyRate());
        teacher.setTeacherEmail(updatedTeacher.getTeacherEmail());
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.toTeacherDto(teacher);
    }
    @Override
    public void deleteTeacher(long teacherId) {
        teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher with {id} not found"+ teacherId));
        teacherRepository.deleteById(teacherId);
    }
    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map((teacher) -> TeacherMapper.toTeacherDto(teacher))
                .collect(java.util.stream.Collectors.toList());
    }
}
