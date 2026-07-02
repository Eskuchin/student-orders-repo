package com.example.studentorders.dto;

import com.example.studentorders.entity.OrderStatus;
import com.example.studentorders.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class OrderRequest {
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private BigDecimal total;
    @Getter
    @Setter
    private OrderStatus orderStatus;
}
