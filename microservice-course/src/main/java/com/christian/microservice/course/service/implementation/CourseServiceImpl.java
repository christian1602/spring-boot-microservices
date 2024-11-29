package com.christian.microservice.course.service.implementation;

import com.christian.microservice.course.client.IStudentClient;
import com.christian.microservice.course.http.response.StudentByCourseResponse;
import com.christian.microservice.course.persistence.entity.CourseEntity;
import com.christian.microservice.course.persistence.repository.ICourseRepository;
import com.christian.microservice.course.presentation.dto.StudentDTO;
import com.christian.microservice.course.service.interfaces.ICourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    private final IStudentClient studentClient;

    public CourseServiceImpl(ICourseRepository courseRepository, IStudentClient studentClient){
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) this.courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CourseEntity findById(Long id) {
        return this.courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: ".concat(id.toString())));
    }

    @Override
    @Transactional
    public CourseEntity save(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentByCourseResponse findStudentByCourseId(Long courseId) {
        // Consultar el curso
        CourseEntity courseFound = this.courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: ".concat(courseId.toString())));

        // Obtener los estudiantes
        List<StudentDTO> studentDTOList = this.studentClient.findAllStudentsByCourse(courseId);

        // Retornando StudentByCourseResponse
        return new StudentByCourseResponse(courseFound.getName(), courseFound.getTeacher(), studentDTOList);
    }
}
