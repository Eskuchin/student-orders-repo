package com.example.studentorders.service;

import com.example.studentorders.dto.StudentRequest;
import com.example.studentorders.dto.StudentResponse;
import com.example.studentorders.entity.School;
import com.example.studentorders.entity.Student;
import com.example.studentorders.mapper.StudentMapper;
import com.example.studentorders.repository.SchoolRepository;
import com.example.studentorders.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentService(StudentRepository studentRepository,
                          SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> studentResponse = studentRepository.findAll().stream()
                .map(StudentMapper::toResponse)
                .toList();
        return studentResponse;
    }

    public StudentResponse getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.toResponse(student);
    }

    public StudentResponse createStudent(StudentRequest request) {

        School school = schoolRepository.findById(request.getSchoolId())
                .orElseThrow(() -> new RuntimeException("School not found"));

        Student student = StudentMapper.toEntity(request, school);

        Student saved = studentRepository.save(student);

        return StudentMapper.toResponse(saved);
    }

    public StudentResponse updateStudent(Long id, StudentRequest request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        School school = schoolRepository.findById(request.getSchoolId())
                .orElseThrow(() -> new RuntimeException("School not found"));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setGrade(request.getGrade());
        student.setSchool(school);
        student.setEmail(request.getEmail());

        Student updated = studentRepository.save(student);

        return StudentMapper.toResponse(updated);
    }
}
