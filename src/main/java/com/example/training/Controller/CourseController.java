package com.example.training.Controller;

import com.example.training.Serivce.DTO.CourseDto;
import com.example.training.Serivce.CourseService;
import com.example.training.Serivce.DTO.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/university/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/create")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto){
        CourseDto course = courseService.createCourse(courseDto);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable(name = "id") Long courseId){
        CourseDto course = courseService.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDto updatedCourse){
        CourseDto courseDto = courseService.updateCourse(courseId, updatedCourse);
        return ResponseEntity.ok(courseDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Course deleted successfully!.");
    }
}
