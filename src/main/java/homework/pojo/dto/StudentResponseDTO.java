package homework.pojo.dto;

import homework.pojo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private List<studentDTO> studentList;

    @Data
    @AllArgsConstructor
    public static class studentDTO{
        private String id;
        private String name;

        public studentDTO(Student stu) {
            this.id = stu.getId();
            this.name = stu.getName();
        }
    }
}
