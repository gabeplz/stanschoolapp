package crudgedoe.crudtest.service;

import crudgedoe.crudtest.dto.CourseGetDto;
import crudgedoe.crudtest.dto.CoursePostDto;
import crudgedoe.crudtest.mapper.CourseMapper;
import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.models.Student;
import crudgedoe.crudtest.repository.CourseRepository;
import crudgedoe.crudtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseMapper courseMapper;

//    public Course newCourse(Course course) {
//        return courseRepository.save(course);
//    }

    public void newCourse(CoursePostDto course){
        Course newCourse = courseMapper.toEntity(course);
        courseRepository.save(newCourse);
    }

//    public Optional<Course> getCourseById(long id) {return courseRepository.findById(id);}

    public CourseGetDto getCourseById(Long id){
        Course course = courseRepository.findById(id).get();
        return courseMapper.toDto(course);
    }

    public Iterable<CourseGetDto> getAllCourses() {
        Iterable<Course> courses = courseRepository.findAll();
        List<CourseGetDto> courseGetDtoList = new ArrayList<CourseGetDto>();
        courses.forEach(course -> courseGetDtoList.add(courseMapper.toDto(course)));
        return courseGetDtoList;
    }



    public Iterable<Course> getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }

    public Course updateCourseById(long id, Course course) {
        if (!courseRepository.existsById(id)) {
            return null;
        }
        Course oldCourse = courseRepository.findById(id).get();

        if (course.getName() != null) {
            oldCourse.setName(course.getName());
        }

        if (course.getCredits() != null) {
            oldCourse.setCredits(course.getCredits());
        }
        System.out.println(course.getName());
        System.out.println(course.getCredits());

        return courseRepository.save(oldCourse);
    }

    public String deleteCourseById(long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return "goed gedaan";
        }
        return "no course with matching id found";
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

//    public void addStudentToCourse(long courseid, long leerlingid) {
//        Course tempCourse = courseRepository.findById(courseid).get();
//        Student tempStudent = studentService.getLeerlingById(leerlingid).get();
//
//        tempCourse.getStudent().add(tempStudent);
//        tempStudent.getCourses().add(tempCourse);
//
//        courseRepository.save(tempCourse);
//    }

    public void addStudentToCourse(Long StudentId,Long courseId){
        Course tempCourse = courseRepository.findById(courseId).get();
        Student tempStudent = studentRepository.findById(courseId).get();
        tempCourse.getStudent().add(tempStudent);
        tempStudent.getCourses().add(tempCourse);
        courseRepository.save(tempCourse);
    }
}
