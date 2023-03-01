package crudgedoe.crudtest.dto;

import crudgedoe.crudtest.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoursePostDto {
    private String name;
    private Integer credits;
    private List<Student> student;
}
