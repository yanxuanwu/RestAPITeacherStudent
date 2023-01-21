package homework.service;

import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentResponseDTO getAllStu();
    StudentDTO getStudentById(String id);
    StudentDTO insertStudent(Student student);
    StudentDTO updateStudent(Student student);
    void deleteStudentById(String id);
    void deleteStudent(Student student);
}
