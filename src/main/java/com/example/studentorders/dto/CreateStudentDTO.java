package com.example.studentorders.dto;

public class CreateStudentDTO {

    @lombok.Setter
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

    public CreateStudentDTO() {}

}