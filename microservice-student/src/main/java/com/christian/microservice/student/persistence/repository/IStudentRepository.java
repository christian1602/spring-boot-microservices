package com.christian.microservice.student.persistence.repository;

import com.christian.microservice.student.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<StudentEntity, Long> {

    // PRIMERA FORMA
    @Query("SELECT s FROM StudentEntity s WHERE s.courseId = :courseId")
    List<StudentEntity> findAllStudents(Long courseId);

    // SEGUNDA FORMA
    // SELECT * FROM students WHERE course_id = ?;
    // List<StudentEntity> findAllByCourseId(Long courseId);
}
