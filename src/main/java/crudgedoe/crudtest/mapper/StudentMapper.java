package crudgedoe.crudtest.mapper;

import crudgedoe.crudtest.dto.StudentGetDto;
import crudgedoe.crudtest.dto.StudentPostDto;
import crudgedoe.crudtest.models.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentGetDto toDto(Student student);
    Student toEntity(StudentPostDto student);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudent(StudentPostDto studentDto, @MappingTarget Student student);



}
