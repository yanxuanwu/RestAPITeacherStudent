package homework.service.impl;


import homework.exception.ResourceNotFoundException;
import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import homework.repository.StudentRepositoryCustom;
import homework.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepositoryCustom studentRepository;

    
    public StudentServiceImpl(StudentRepositoryCustom studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO getAllStu(){
        Collection<Student> studentCollection = studentRepository.findAll();
        List<StudentDTO> studentDTOS = studentCollection.stream().map(s -> new StudentDTO(s)).collect(Collectors.toList());
        return new StudentResponseDTO(studentDTOS);
    }

    @Override
    public StudentDTO getStudentById(String id) {
        Logger logger = (Logger) LogManager.getLogger(StudentServiceImpl.class.getName());
        Student student = studentRepository.findByStudentId(id);
        if (student == null) {
            logger.log(Level.INFO, "throw an exception here");
            throw new ResourceNotFoundException("student object is null");
        }
        return new StudentDTO(student);
    }

    @Override
    public StudentDTO insertStudent(Student student) {
        return new StudentDTO(studentRepository.insertStudent(student));
    }

    @Override
    public StudentDTO updateStudent(Student student) {
        return new StudentDTO(studentRepository.updateStudent(student));
    }


    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteByStudentId(id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.deleteStudent(student);
    }


}
