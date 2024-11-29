package com.christian.microservice.course.presentation.dto;

public record ResponseCourseDTO<T>(
        String message,
        T data
) {
}
