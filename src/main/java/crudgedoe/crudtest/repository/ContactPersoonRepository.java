package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.ContactPersoon;
import crudgedoe.crudtest.models.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactPersoonRepository extends CrudRepository<ContactPersoon,Long> {


    Iterable<ContactPersoon> getContactPersoonByName(String name);
}
