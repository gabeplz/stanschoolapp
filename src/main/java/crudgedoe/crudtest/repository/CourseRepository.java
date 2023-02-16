package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.models.Leerling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CourseRepository extends CrudRepository <Course,Long> {

    Iterable<Course> getCourseByName(String naam);

}
