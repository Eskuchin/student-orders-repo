package com.example.studentorders.dto;

import lombok.Setter;

public class StudentRequest {
    @Setter
    @lombok.Getter
    private String firstName;
    @lombok.Setter
    @lombok.Getter
    private String lastName;
    @lombok.Setter
    @lombok.Getter
    private Integer grade;
    @lombok.Setter
    @lombok.Getter
    private Long schoolId;

}
