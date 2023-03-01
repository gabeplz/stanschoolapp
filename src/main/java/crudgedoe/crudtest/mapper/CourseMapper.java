package crudgedoe.crudtest.mapper;

import crudgedoe.crudtest.dto.ContactPersonGetDto;
import crudgedoe.crudtest.dto.ContactPersonPostDto;
import crudgedoe.crudtest.dto.CourseGetDto;
import crudgedoe.crudtest.dto.CoursePostDto;
import crudgedoe.crudtest.models.ContactPerson;
import crudgedoe.crudtest.models.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseGetDto toDto(Course course);
    Course toEntity(CoursePostDto Course);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourse(CoursePostDto courseDto, @MappingTarget Course course);
}
