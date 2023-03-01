package crudgedoe.crudtest.mapper;

import crudgedoe.crudtest.dto.ContactPersonGetDto;
import crudgedoe.crudtest.dto.ContactPersonPostDto;
import crudgedoe.crudtest.models.ContactPerson;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ContactPersonMapper {
    ContactPersonGetDto toDto(ContactPerson contactPerson);
    ContactPerson toEntity(ContactPersonPostDto contactPersoon);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactPersoon(ContactPersonPostDto rabbitDto, @MappingTarget ContactPerson contactPerson);

}
