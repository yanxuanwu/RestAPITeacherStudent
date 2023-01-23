package homework.controller;

import homework.exception.ResourceNotFoundException;
import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import homework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<StudentResponseDTO> getAllStudent(){
        return new ResponseEntity<>(service.getAllStu(), HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> insertStudent(@RequestBody Student stu) {
        service.insertStudent(stu);
        return new ResponseEntity<>(service.insertStudent(stu), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateStudent( @RequestBody Student stu) {
        service.updateStudent(stu);
        return new ResponseEntity<>(service.updateStudent(stu), HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable String id) {
        service.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<StudentDTO> deleteStudentById(@RequestBody Student stu) {
        service.deleteStudent(stu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }


}


