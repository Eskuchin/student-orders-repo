package com.example.studentorders.mapper;

import com.example.studentorders.dto.OrderDTO;
import com.example.studentorders.dto.StudentDTO;
import com.example.studentorders.entity.Order;
import com.example.studentorders.entity.Student;

import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {

        StudentDTO dto = new StudentDTO();

        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setGrade(student.getGrade());

        if (student.getSchool() != null) {
            dto.setSchoolName(student.getSchool().getName());
        }

        if (student.getOrders() != null) {
            dto.setOrders(
                    student.getOrders()
                            .stream()
                            .map(StudentMapper::toOrderDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    private static OrderDTO toOrderDTO(Order order) {

        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setDescription(order.getDescription());
        dto.setTotal(order.getTotal());
        dto.setStatus(order.getStatus().name());

        return dto;
    }
}