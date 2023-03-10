package homework.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "id", initialValue = 1)
    private String id;
    @Column
    private String name;

    @OneToMany(mappedBy = "stu",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Teacher_Student> teacher_students = new ArrayList<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Teacher_Student> getTeacher_Students() {
        return teacher_students;
    }

    public void setTeacher_Students(List<Teacher_Student> ts) {
        this.teacher_students = ts;
    }


}
