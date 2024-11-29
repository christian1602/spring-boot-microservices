package com.christian.microservice.course.presentation.dto;

public record StudentDTO(
        String name,
        String lastName,
        String email,
        Long courseId
) {
}