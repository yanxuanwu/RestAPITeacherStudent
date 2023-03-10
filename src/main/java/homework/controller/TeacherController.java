package homework.controller;

import homework.pojo.dto.TeacherResponseDTO;
import homework.pojo.dto.TeacherResponseDTO.*;
import homework.pojo.entity.Teacher;
import homework.repository.TeacherRepositoryCustom;
import homework.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    @Qualifier("teacherServiceImpl")
    private final TeacherService service;

    public TeacherController(@Qualifier("teacherServiceImpl") TeacherService service) {
        this.service = service;
    }

    @GetMapping("/{Id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable String id) {
        return new ResponseEntity<>(service.getTeacherById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<TeacherResponseDTO> getAllTeachers() {
        return new ResponseEntity<>(service.getAllTeacher(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(service.updateTeacher(teacher), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> insertTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(service.insertTeacher(teacher), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherDTO> deleteTeacherById(@PathVariable String id) {
        service.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<TeacherDTO> deleteTeacher(@RequestBody Teacher teacher) {
        service.deleteTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
