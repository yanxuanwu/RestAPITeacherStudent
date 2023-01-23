package homework.repository;

import homework.pojo.entity.Student;

import java.util.List;

@Repository
public interface StudentRepositoryCustom {
    Student findByStudentId(String id);
    List<Student> findAll();
    void deleteByStudentId(String id);
    void deleteStudent(Student std);
    Student updateStudent(Student stu);
    Student insertStudent(Student stu);
}
