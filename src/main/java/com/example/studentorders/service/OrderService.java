package com.example.studentorders.service;

import com.example.studentorders.dto.OrderRequest;
import com.example.studentorders.dto.OrderResponse;
import com.example.studentorders.entity.Order;
import com.example.studentorders.entity.Student;
import com.example.studentorders.mapper.OrderMapper;
import com.example.studentorders.repository.OrderRepository;
import com.example.studentorders.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final StudentRepository studentRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository,
                        StudentRepository studentRepository,
                        OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.studentRepository = studentRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderResponse> getOrdersByStudentId(Long studentId) {
        return orderRepository.findByStudentId(studentId)
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }

    public OrderResponse createOrder(Long studentId, OrderRequest request) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Order order = orderMapper.toEntity(request, student);

        Order saved = orderRepository.save(order);

        return orderMapper.toResponse(saved);
    }
}