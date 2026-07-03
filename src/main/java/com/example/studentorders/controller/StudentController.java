package com.example.studentorders.controller;

import com.example.studentorders.dto.StudentRequest;
import com.example.studentorders.dto.StudentResponse;
import com.example.studentorders.mapper.StudentMapper;
import com.example.studentorders.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(int id) {
        StudentResponse studentResponse = studentService.getStudent(Long.valueOf(id));

        return studentResponse;
    }

    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }

    @PutMapping
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }
}