package com.christian.microservice.student.presentation.controller;

import com.christian.microservice.student.persistence.entity.StudentEntity;
import com.christian.microservice.student.presentation.dto.ResponseStudentDTO;
import com.christian.microservice.student.service.interfaces.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<StudentEntity> students = this.studentService.findAll();

        ResponseStudentDTO<List<StudentEntity>> response = new ResponseStudentDTO<>("List of students", students);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        StudentEntity studentFound = this.studentService.findById(id);

        ResponseStudentDTO<StudentEntity> response = new ResponseStudentDTO<>("Student found successfully", studentFound);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody StudentEntity studentEntity) {
        StudentEntity studentCreated = this.studentService.save(studentEntity);

        ResponseStudentDTO<StudentEntity> response = new ResponseStudentDTO<>("Student created successfully", studentCreated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ENDPOINT que es llamado desde microservice-course
    // Retorna directamente List<StudentEntity> con el status de OK debido a que
    // this.studentService.findByCourseId(courseId) retorna List<StudentEntity>
    // y el metodo findAllStudentsByCourse de la interfaz IStudentClient retorna List<StudentDTO>
    // esto para facilitar la conversion de List<StudentEntity> a List<StudentDTO>
    // Pero si se quisiera devolver un ResponseStudentDTO<> es posible que se necesite un mapper
    @GetMapping("/search-by-course/{courseId}")
    public ResponseEntity<?> findByCourseId(@PathVariable Long courseId){
        List<StudentEntity> students = this.studentService.findByCourseId(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
