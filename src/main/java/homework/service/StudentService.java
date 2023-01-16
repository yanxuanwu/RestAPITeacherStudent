package homework.service;

import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentResponseDTO getAllStu();
    studentDTO getStudentById(String id);
    void insertStudent(String id, String name);
    void updateStudent(String id, Student student);
    boolean deleteStudent(String id);
}
