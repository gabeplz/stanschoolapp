package crudgedoe.crudtest.dto;

import crudgedoe.crudtest.models.ContactPerson;
import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.models.School;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentPostDto {
    private String name;
    private Integer grade;
    private School school;
    private ContactPerson contactPerson;
    private List<Course> courses;
}
