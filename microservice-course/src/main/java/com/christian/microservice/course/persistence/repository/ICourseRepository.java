package com.christian.microservice.course.persistence.repository;

import com.christian.microservice.course.persistence.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends CrudRepository<CourseEntity, Long>{
}
