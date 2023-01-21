package homework.pojo.dto;

import homework.pojo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private List<StudentDTO> studentList;

    @Data
    @AllArgsConstructor
    public static class StudentDTO{
        private String id;
        private String name;

        public StudentDTO(Student stu) {
            this.id = stu.getId();
            this.name = stu.getName();
        }
    }
}
