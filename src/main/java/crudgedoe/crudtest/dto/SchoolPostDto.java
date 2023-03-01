package crudgedoe.crudtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import crudgedoe.crudtest.models.Student;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SchoolPostDto {
    private String name;
    private Integer amountOfStudents;
    private String city;
    private List<Student> student;
}
