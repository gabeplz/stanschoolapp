package crudgedoe.crudtest.dto;

import crudgedoe.crudtest.models.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactPersonGetDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Student student;
}
