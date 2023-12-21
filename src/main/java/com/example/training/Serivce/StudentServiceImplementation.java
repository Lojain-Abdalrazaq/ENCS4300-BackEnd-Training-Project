package com.example.training.Serivce;

import com.example.training.Entity.Course;
import com.example.training.Repository.CourseRepository;
import com.example.training.ResourceNotFoundException;
import com.example.training.Entity.Student;
import com.example.training.Repository.StudentRepository;
import com.example.training.Serivce.DTO.CourseDto;
import com.example.training.Serivce.DTO.CourseMapper;
import com.example.training.Serivce.DTO.StudentDto;
import com.example.training.Serivce.DTO.StudentMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.toStudent(studentDto);
        student = studentRepository.save(student);
        return StudentMapper.toStudentDto(student);
    }
    @Override
    public StudentDto getStudentById(long id) throws ResourceNotFoundException{
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student with {"+id+"} not found."));
        return StudentMapper.toStudentDto(student);
    }
    @Override
    public StudentDto updateStudent(long studentId, StudentDto updatedStudent) throws ResourceNotFoundException{
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with {"+studentId+"}not found to update."));
        student.setStudentName(updatedStudent.getStudentName());
        student.setStudentBD(updatedStudent.getStudentBD());
        student.setStudentGPA(updatedStudent.getStudentGPA());
        student.setStudentEmail(updatedStudent.getStudentEmail());
        student.setStudentPhone(updatedStudent.getStudentPhone());
        student.setStudentAddress(updatedStudent.getStudentAddress());
        student = studentRepository.save(student);
        return StudentMapper.toStudentDto(student);
    }
    @Override
    public void deleteStudent(long studentId) throws ResourceNotFoundException{
        studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with {"+studentId+"} not found!, We cant find the student to delete."));
        studentRepository.deleteById(studentId);
    }
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.toStudentDto(student))
                .collect(java.util.stream.Collectors.toList());
    }
    @Override
    public void enrollStudentInCourse(Long studentId, Long courseId) throws ResourceNotFoundException{
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with {"+studentId+"}not found."));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course with {"+courseId+"}not found."));
        student.getEnrolledCourses().add(course);
        studentRepository.save(student);
    }
    @Override
    public List<CourseDto> getCoursesForStudent(Long studentId) throws ResourceNotFoundException{
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student with {"+studentId+"}not found."));
        return student.getEnrolledCourses().stream().map(CourseMapper::toCourseDto).collect(Collectors.toList());
    }
}
