package homework.repository;

import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository {
    Student findById(String id);
    Collection<Student> findAll();
    studentDTO save(String id, Student student);
    boolean deleteById(String id);
}
