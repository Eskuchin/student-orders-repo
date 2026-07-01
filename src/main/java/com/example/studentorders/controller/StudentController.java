package com.example.studentorders.controller;

import com.example.studentorders.dto.StudentDTO;
import com.example.studentorders.mapper.StudentMapper;
import com.example.studentorders.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentMapper::toDTO)
                .toList();
    }
}