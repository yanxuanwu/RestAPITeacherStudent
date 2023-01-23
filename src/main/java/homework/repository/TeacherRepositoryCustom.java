package homework.repository;

import homework.pojo.entity.Student;
import homework.pojo.entity.Teacher;

import java.util.List;

@Repository
public interface TeacherRepositoryCustom {
    Teacher findTeacherById(String id);
    List<Teacher> findAllTeacher();
    void deleteByTeacherId(String id);
    void deleteTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Teacher insertTeacher(Teacher teacher);
}
