package com.christian.microservice.student.service.interfaces;

import com.christian.microservice.student.persistence.entity.StudentEntity;

import java.util.List;

public interface IStudentService {
    List<StudentEntity> findAll();
    StudentEntity findById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    List<StudentEntity> findByCourseId(Long courseId);
}
