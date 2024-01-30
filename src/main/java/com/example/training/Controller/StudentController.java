package com.example.training.Controller;

import com.example.training.Service.DTO.CourseDto;
import com.example.training.Service.DTO.StudentDto;
import com.example.training.Service.Interface.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/university/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") Long studentId){
        StudentDto student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,@RequestBody StudentDto updatedStudent){
        StudentDto studentDto = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(studentDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully!.");
    }
    // for the many to many relationship between student and course
    // the inserion of the entrolledCourses table is done by the student
    @PostMapping("/enroll/{studentId}/course/{courseId}")
    public ResponseEntity<Void> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enrollStudentInCourse(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesForStudent(@PathVariable Long studentId) {
        List<CourseDto> courses = studentService.getCoursesForStudent(studentId);
        return ResponseEntity.ok(courses);
    }
}
