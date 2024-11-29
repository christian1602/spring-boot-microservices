package com.christian.microservice.course.client;

import com.christian.microservice.course.presentation.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Inicialmente url="localhost:8090/api/student" para consumir microservice-student, cuya URL es localhost:8090
// Posteriormente url="localhost:8080/api/student" para consumir TODO desde microservice-gateway, cuya URL es localhost:8080
@FeignClient(name = "microservice-student", url="localhost:8090/api/student")
public interface IStudentClient {

    @GetMapping("/search-by-course/{courseId}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long courseId);
}
