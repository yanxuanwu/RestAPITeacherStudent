package homework.service;

import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.TeacherResponseDTO;
import homework.pojo.dto.TeacherResponseDTO.*;
import homework.pojo.entity.Student;
import homework.pojo.entity.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    TeacherResponseDTO getAllTeacher();
    TeacherDTO getTeacherById(String id);
    TeacherDTO insertTeacher(Teacher teacher);
    TeacherDTO updateTeacher(Teacher teacher);
    void deleteTeacherById(String id);
    void deleteTeacher(Teacher teacher);
}
