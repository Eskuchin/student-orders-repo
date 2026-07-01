package com.example.studentorders.dto;

import lombok.Setter;

import java.util.List;

public class StudentDTO {

    @Setter
    @lombok.Getter
    private Long id;
    @lombok.Getter
    @Setter
    private String firstName;
    @lombok.Getter
    @Setter
    private String lastName;
    @lombok.Getter
    @Setter
    private Integer grade;

    @lombok.Getter
    @Setter
    private String schoolName;

    @lombok.Getter
    @Setter
    private List<OrderDTO> orders;


}