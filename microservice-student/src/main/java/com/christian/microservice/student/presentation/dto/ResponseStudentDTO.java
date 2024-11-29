package com.christian.microservice.student.presentation.dto;

public record ResponseStudentDTO<T>(
        String message,
        T data
) {
}
