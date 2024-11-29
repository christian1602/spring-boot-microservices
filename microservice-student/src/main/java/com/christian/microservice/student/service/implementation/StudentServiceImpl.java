package com.christian.microservice.student.service.implementation;

import com.christian.microservice.student.persistence.entity.StudentEntity;
import com.christian.microservice.student.persistence.repository.IStudentRepository;
import com.christian.microservice.student.service.interfaces.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> findAll() {
        return (List<StudentEntity>) this.studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentEntity findById(Long id) {
        return this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: ".concat(id.toString())));
    }

    @Override
    @Transactional
    public StudentEntity save(StudentEntity studentEntity) {
        return this.studentRepository.save(studentEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> findByCourseId(Long courseId) {
        return this.studentRepository.findAllStudents(courseId);
    }
}
