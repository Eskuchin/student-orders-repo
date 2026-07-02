package com.example.studentorders.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class OrderResponse {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private BigDecimal total;
    @Getter
    @Setter
    private String status;
}
