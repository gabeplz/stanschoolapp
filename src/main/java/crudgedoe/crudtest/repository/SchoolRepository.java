package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SchoolRepository extends CrudRepository<School,Long> {

    Iterable<School>getSchoolByName(String name);

}
