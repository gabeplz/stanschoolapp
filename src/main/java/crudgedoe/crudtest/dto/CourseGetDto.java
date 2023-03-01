package crudgedoe.crudtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import crudgedoe.crudtest.models.Student;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseGetDto {
    private Long id;
    private String name;
    private Integer credits;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<Student> student;
}
