package com.christian.microservice.course.service.interfaces;

import com.christian.microservice.course.http.response.StudentByCourseResponse;
import com.christian.microservice.course.persistence.entity.CourseEntity;

import java.util.List;

public interface ICourseService {
    List<CourseEntity> findAll();
    CourseEntity findById(Long id);
    CourseEntity save(CourseEntity courseEntity);
    StudentByCourseResponse findStudentByCourseId(Long courseId);
}
