package com.example.studentorders.mapper;

import com.example.studentorders.dto.*;
import com.example.studentorders.entity.Order;
import com.example.studentorders.entity.School;
import com.example.studentorders.entity.Student;

import java.util.stream.Collectors;

public class StudentMapper {

    public static Student toEntity(StudentRequest request, School school) {
        Student student = new Student();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setGrade(request.getGrade());
        student.setSchool(school);
        student.setEmail(request.getEmail());

        return student;
    }

    public static StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setGrade(student.getGrade());
        response.setEmail(student.getEmail());

        if (student.getSchool() != null) {
            response.setSchoolName(student.getSchool().getName());
        }

        return response;
    }

    public static Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();

        order.setDescription(orderRequest.getDescription());
        order.setTotal(orderRequest.getTotal());
        order.setStatus(orderRequest.getOrderStatus());

        return order;
    }


//    public static StudentDTO toDTO(Student student) {
//
//        StudentDTO dto = new StudentDTO();
//
//        dto.setId(student.getId());
//        dto.setFirstName(student.getFirstName());
//        dto.setLastName(student.getLastName());
//        dto.setGrade(student.getGrade());
//
//        if (student.getSchool() != null) {
//            dto.setSchoolName(student.getSchool().getName());
//        }
//
//        if (student.getOrders() != null) {
//            dto.setOrders(
//                    student.getOrders()
//                            .stream()
//                            .map(StudentMapper::toOrderDTO)
//                            .collect(Collectors.toList())
//            );
//        }
//
//        return dto;
//    }

//    private static OrderDTO toOrderDTO(Order order) {
//
//        OrderDTO dto = new OrderDTO();
//
//        dto.setId(order.getId());
//        dto.setDescription(order.getDescription());
//        dto.setTotal(order.getTotal());
//        dto.setStatus(order.getStatus().name());
//
//        return dto;
//    }
}