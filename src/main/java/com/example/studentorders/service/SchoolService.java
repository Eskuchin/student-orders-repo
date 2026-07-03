package com.example.studentorders.service;

import com.example.studentorders.dto.SchoolResponse;
import com.example.studentorders.mapper.SchoolMapper;
import com.example.studentorders.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolResponse> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toResponse)
                .toList();
    }
}