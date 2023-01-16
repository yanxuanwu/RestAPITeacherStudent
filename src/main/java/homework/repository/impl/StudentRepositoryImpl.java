package homework.repository.impl;

import homework.pojo.dto.StudentResponseDTO.*;
import homework.pojo.entity.Student;
import homework.repository.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class StudentRepositoryImpl implements StudentRepository {
    private final Map<String, Student> map = new ConcurrentHashMap<>();
    @PostConstruct
    public void init(){
        map.put("1", new Student("1", "Tom", 0, true));
        map.put("2", new Student("2", "Jerry", 0, true));
    }

    @Override
    public Student findById(String id) {
        return map.get(id);
    }

    @Override
    public Collection<Student> findAll() {
        return map.values();
    }

    @Override
    public void save(String id, Student student) {
        map.put(id, student);
    }

    @Override
    public boolean deleteById(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
            return true;
        }
        return false;
    }

}
