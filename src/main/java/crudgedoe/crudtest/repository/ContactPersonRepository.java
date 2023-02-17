package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.ContactPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactPersonRepository extends CrudRepository<ContactPerson,Long> {

    Iterable<ContactPerson> getContactPersonByName(String name);
}
