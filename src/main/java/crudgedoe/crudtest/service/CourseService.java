package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.models.School;
import crudgedoe.crudtest.repository.CourseRepository;
import crudgedoe.crudtest.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CourseService {


    @Autowired
    CourseRepository courseRepository;

    public Course newCourse(Course course) {
        return courseRepository.save(course);
    }


    public Iterable<Course> getAllCourses() { return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(long id) {
        return courseRepository.findById(id);
    }

    public Iterable<Course> getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }

    public Course updateCoursebyId(long id, Course course) {
        if(!courseRepository.existsById(id)){
            return null;
        }
        Course oldCourse = courseRepository.findById(id).get();

        if (course.getName() != null){
            oldCourse.setName(course.getName());
        }

        if (course.getCredits() != null){
            oldCourse.setCredits(course.getCredits());
        }
        System.out.println(course.getName());
        System.out.println(course.getCredits());

        return courseRepository.save(oldCourse);
    }


    public String deleteCourseById(long id) {
        if (courseRepository.existsById(id)){
            courseRepository.deleteById(id);
            return "goed gedaan";
        }
        return "die bestaat niet";
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
