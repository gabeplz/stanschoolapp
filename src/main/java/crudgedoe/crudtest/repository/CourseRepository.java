package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CourseRepository extends CrudRepository<Course, Long> {

    Iterable<Course> getCourseByName(String naam);
}
