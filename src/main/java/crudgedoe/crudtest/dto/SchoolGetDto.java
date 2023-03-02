package crudgedoe.crudtest.dto;

import crudgedoe.crudtest.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SchoolGetDto {
    private Long id;
    private String name;
    private Integer amountOfStudents;
    private String city;
    private List<Student> student;
}
