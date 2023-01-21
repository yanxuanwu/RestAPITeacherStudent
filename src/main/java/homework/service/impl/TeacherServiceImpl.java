package homework.service.impl;

import homework.exception.ResourceNotFoundException;
import homework.pojo.dto.StudentResponseDTO;
import homework.pojo.dto.TeacherResponseDTO;
import homework.pojo.dto.TeacherResponseDTO.*;
import homework.pojo.entity.Teacher;
import homework.repository.TeacherRepositoryCustom;
import homework.service.TeacherService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepositoryCustom teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepositoryCustom teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherResponseDTO getAllTeacher() {
        List<Teacher> teacherList = teacherRepository.findAllTeacher();
        List<TeacherDTO> teacherDTOS = teacherList.stream().map(s -> new TeacherDTO(s)).collect(Collectors.toList());
        return new TeacherResponseDTO(teacherDTOS);
    }

    @Override
    public TeacherDTO getTeacherById(String id) {
        Logger logger = (Logger) LogManager.getLogger(StudentServiceImpl.class.getName());
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            logger.log(Level.INFO, "throw an exception here");
            throw new ResourceNotFoundException("teacher object is null");
        }
        return new TeacherDTO(teacher);
    }

    @Override
    public TeacherDTO insertTeacher(Teacher teacher) {
        teacherRepository.insertTeacher(teacher);
        return new TeacherDTO(teacher);
    }

    @Override
    public TeacherDTO updateTeacher(Teacher teacher) {
        return new TeacherDTO(teacherRepository.updateTeacher(teacher));
    }

    @Override
    public void deleteTeacherById(String id) {
        teacherRepository.deleteByTeacherId(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.deleteTeacher(teacher);
    }
}
