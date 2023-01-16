package homework.service.impl;


import homework.exception.ResourceNotFoundException;
import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import homework.repository.StudentRepository;
import homework.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO getAllStu(){
        Collection<Student> studentCollection = studentRepository.findAll();
        List<studentDTO> studentDTOS = studentCollection.stream().map(s -> new studentDTO(s)).collect(Collectors.toList());
        return new StudentResponseDTO(studentDTOS);
    }

    @Override
    public studentDTO getStudentById(String id) {
        Logger logger = (Logger) LogManager.getLogger(StudentServiceImpl.class.getName());
        logger.info(id);
        Student student = studentRepository.findById(id);
        logger.info(student.getName());
        if (student == null) {
            logger.info("throw an exception here");
            throw new ResourceNotFoundException("student object is null");
        }
        return new studentDTO(student);
    }

    @Override
    public void insertStudent(String id, String name) {
        Student student = new Student(id, name, 0, true);
        studentRepository.save(id, student);
    }

    @Override
    public void updateStudent(String id, Student stu) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new ResourceNotFoundException("student object is null");
        }
        student.setId(stu.getId());
        student.setName(stu.getName());
        student.setGrade(stu.getGrade());
        student.setEnrolled(stu.isEnrolled());
        studentRepository.save(id, student);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentRepository.deleteById(id);
    }


}
