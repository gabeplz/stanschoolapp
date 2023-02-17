package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends CrudRepository<Student, Long> {

    Iterable<Student> getStudentByName(String naam);
}
