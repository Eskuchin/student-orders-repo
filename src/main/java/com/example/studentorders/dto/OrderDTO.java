package com.example.studentorders.dto;

import java.math.BigDecimal;

public class OrderDTO {

    @lombok.Setter
    @lombok.Getter
    private Long id;
    @lombok.Setter
    @lombok.Getter
    private String description;
    @lombok.Setter
    @lombok.Getter
    private BigDecimal total;
    @lombok.Setter
    @lombok.Getter
    private String status;

}