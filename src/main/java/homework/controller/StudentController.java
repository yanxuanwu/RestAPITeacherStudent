package homework.controller;

import homework.exception.ResourceNotFoundException;
import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import homework.service.StudentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public ResponseEntity<StudentResponseDTO> getStudent(@RequestParam(required = false) String name){
        return new ResponseEntity<>(service.getAllStu(), HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<studentDTO> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    public ResponseEntity<studentDTO> saveStudent(@RequestBody Student stu) {
        studentDTO new_stu = service.insertStudent(stu.getId(), stu.getName());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("student", "/api/student/" + new_stu.getId());
        return new ResponseEntity<>(new_stu, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> getStudent(@RequestBody Student stu) {
        return new ResponseEntity<>("1", HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<studentDTO> updateStudent(@PathVariable String id, @RequestBody Student stu) {
        service.updateStudent(id, stu);
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<studentDTO> deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }


}


