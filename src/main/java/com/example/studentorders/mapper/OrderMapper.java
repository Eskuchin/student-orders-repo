package com.example.studentorders.mapper;

import com.example.studentorders.dto.OrderRequest;
import com.example.studentorders.dto.OrderResponse;
import com.example.studentorders.entity.Order;
import com.example.studentorders.entity.OrderStatus;
import com.example.studentorders.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequest request, Student student) {
        Order order = new Order();

        order.setDescription(request.getDescription());
        order.setTotal(request.getTotal());
        order.setStatus(OrderStatus.valueOf(request.getStatus()));
        order.setStudent(student);

        return order;
    }

    public OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();

        response.setId(order.getId());
        response.setDescription(order.getDescription());
        response.setTotal(order.getTotal());
        response.setStatus(order.getStatus().name());

        return response;
    }
}