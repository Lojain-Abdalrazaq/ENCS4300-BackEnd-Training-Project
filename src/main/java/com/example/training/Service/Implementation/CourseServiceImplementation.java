package com.example.training.Service.Implementation;

import com.example.training.Entity.Department;
import com.example.training.Entity.Teacher;
import com.example.training.Repository.DepartmentRepository;
import com.example.training.Repository.TeacherRepository;
import com.example.training.Service.Handler.ResourceNotFoundException;
import com.example.training.Service.Interface.CourseService;
import com.example.training.Service.DTO.CourseDto;
import com.example.training.Entity.Course;
import com.example.training.Repository.CourseRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public CourseDto createCourse(CourseDto courseDto) throws ResourceNotFoundException{
        Department department = departmentRepository.findById(courseDto.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department with {"+courseDto.getDepartmentId()+"} not found"));
        Teacher teacher = teacherRepository.findById(courseDto.getTeacherId()).orElseThrow(() -> new ResourceNotFoundException("Teacher with {"+courseDto.getTeacherId()+"} not found"));
        Course course = modelMapper.map(courseDto, Course.class);
        course.setDepartment(department);
        course.setTeacher(teacher);
        course = courseRepository.save(course);
        return modelMapper.map(course, CourseDto.class);
    }
    @Override
    public CourseDto getCourseById(long id) throws ResourceNotFoundException{
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course with {"+id+"} not found"));
        return modelMapper.map(course, CourseDto.class);
    }
    @Override
    public CourseDto updateCourse(long courseId, CourseDto updatedCourse) throws ResourceNotFoundException{
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course with {"+courseId+"} not found"));
        if(updatedCourse.getCourseCode() != null){
            course.setCourseCode(updatedCourse.getCourseCode());
        }
        if(updatedCourse.getCourseName() != null){
            course.setCourseName(updatedCourse.getCourseName());
        }
        if(updatedCourse.getCourseDescription() != null){
            course.setCourseDescription(updatedCourse.getCourseDescription());
        }
        if(updatedCourse.getCoursePrerequisite() != null){
            course.setCoursePrerequisite(updatedCourse.getCoursePrerequisite());
        }
        if(updatedCourse.getCourseCredit() != 0){
            course.setCourseCredit(updatedCourse.getCourseCredit());
        }
        course = courseRepository.save(course);
        return modelMapper.map(course, CourseDto.class);
    }
    @Override
    public void deleteCourse(long courseId) throws ResourceNotFoundException{
        courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course with {"+courseId+" not found"));
        courseRepository.deleteById(courseId);
    }
    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map((course) -> modelMapper.map(course, CourseDto.class))
                .collect(java.util.stream.Collectors.toList());
    }
}
