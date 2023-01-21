package homework.repository.impl;

import homework.pojo.entity.Student;
import homework.repository.StudentRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.*;

@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student findByStudentId(String id) {
        Student stu = entityManager.find(Student.class, id);
        if (stu == null) {
            throw new EntityNotFoundException("Can't find Student with ID " + id);
        }
        return stu;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = entityManager.createNativeQuery("select s from Student s").getResultList();
        return studentList;
    }

    @Override
    public void deleteByStudentId(String id) {
        Student stu = entityManager.find(Student.class, id);
        if (stu != null) {
            entityManager.remove(stu);
        }
        throw new EntityNotFoundException("Can't find Teacher with ID " + id);
    }

    @Override
    public void deleteStudent(Student stu) {
        entityManager.remove(stu);
    }


    @Override
    public Student updateStudent(Student stu) {
        return entityManager.merge(stu);
    }

    @Override
    public Student insertStudent(Student stu) {
        entityManager.persist(stu);
        return stu;
    }
}
