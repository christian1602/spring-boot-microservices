package com.christian.microservice.course.presentation.controller;

import com.christian.microservice.course.http.response.StudentByCourseResponse;
import com.christian.microservice.course.persistence.entity.CourseEntity;
import com.christian.microservice.course.presentation.dto.ResponseCourseDTO;
import com.christian.microservice.course.service.interfaces.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final ICourseService courseService;

    public CourseController(ICourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<CourseEntity> courses = this.courseService.findAll();
        ResponseCourseDTO<List<CourseEntity>> response = new ResponseCourseDTO<>("List of courses",courses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        CourseEntity courseFound = this.courseService.findById(id);
        ResponseCourseDTO<CourseEntity> response = new ResponseCourseDTO<>("Course found successfully", courseFound);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody CourseEntity courseEntity) {
        CourseEntity courseCreated = this.courseService.save(courseEntity);

        ResponseCourseDTO<CourseEntity> response = new ResponseCourseDTO<>("Course created successfully", courseCreated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/search-student/{courseId}")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable Long courseId){
        StudentByCourseResponse response = this.courseService.findStudentByCourseId(courseId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
