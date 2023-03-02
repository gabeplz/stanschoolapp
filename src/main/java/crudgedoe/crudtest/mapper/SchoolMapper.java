package crudgedoe.crudtest.mapper;

import crudgedoe.crudtest.dto.SchoolGetDto;
import crudgedoe.crudtest.dto.SchoolPostDto;
import crudgedoe.crudtest.dto.StudentGetDto;
import crudgedoe.crudtest.dto.StudentPostDto;
import crudgedoe.crudtest.models.School;
import crudgedoe.crudtest.models.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolGetDto toDto(School school);
    School toEntity(SchoolPostDto school);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSchool(SchoolPostDto schoolDto, @MappingTarget School school);

}
