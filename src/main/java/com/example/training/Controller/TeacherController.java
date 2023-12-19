package com.example.training.Controller;

import com.example.training.Serivce.DTO.StudentDto;
import com.example.training.Serivce.DTO.TeacherDto;
import com.example.training.Serivce.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/university/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/create")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
        TeacherDto teacher = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable(name = "id") Long teacherId){
        TeacherDto teacher = teacherService.getTeacherById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("id") Long teacherId, @RequestBody TeacherDto updatedTeacher){
        TeacherDto teacherDto = teacherService.updateTeacher(teacherId, updatedTeacher);
        return ResponseEntity.ok(teacherDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully!.");
    }
    @GetMapping("/all")
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }
}
