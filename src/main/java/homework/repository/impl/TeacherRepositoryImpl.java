package homework.repository.impl;

import homework.pojo.entity.Teacher;
import homework.repository.TeacherRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TeacherRepositoryImpl implements TeacherRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher findTeacherById(String id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher == null) {
            throw new EntityNotFoundException("Can't find Teacher with ID " + id);
        }
        return teacher;
    }

    @Override
    public List<Teacher> findAllTeacher() {
        List<Teacher> teacherList = entityManager.createNativeQuery("select t from teacher t").getResultList();
        return teacherList;
    }

    @Override
    public void deleteByTeacherId(String id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
        throw new EntityNotFoundException("Can not find teacher with id " +  id);

    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    @Override
    public Teacher insertTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }
}
