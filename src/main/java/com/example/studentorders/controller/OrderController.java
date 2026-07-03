package com.example.studentorders.controller;

import com.example.studentorders.dto.OrderRequest;
import com.example.studentorders.dto.OrderResponse;
import com.example.studentorders.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getOrders(@PathVariable Long studentId) {
        return orderService.getOrdersByStudentId(studentId);
    }

    @PostMapping
    public OrderResponse createOrder(@PathVariable Long studentId,
                                     @RequestBody OrderRequest request) {
        return orderService.createOrder(studentId, request);
    }
}