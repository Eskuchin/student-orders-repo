package com.example.studentorders.mapper;

import com.example.studentorders.dto.SchoolResponse;
import com.example.studentorders.entity.School;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public SchoolResponse toResponse(School school) {
        if (school == null) {
            return null;
        }

        SchoolResponse response = new SchoolResponse();
        response.setId(school.getId());
        response.setName(school.getName());

        return response;
    }
}