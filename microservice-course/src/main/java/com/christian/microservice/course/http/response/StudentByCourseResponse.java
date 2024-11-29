package com.christian.microservice.course.http.response;

import com.christian.microservice.course.presentation.dto.StudentDTO;

import java.util.List;

public record StudentByCourseResponse(
        String courseName,
        String teacher,
        List<StudentDTO> studentDTOList
) {
}
