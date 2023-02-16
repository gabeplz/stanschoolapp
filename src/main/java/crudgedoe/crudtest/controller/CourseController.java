package crudgedoe.crudtest.controller;

import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/new")
    public Course newCourse(@RequestBody Course course){
        return courseService.newCourse(course);
    }

    @GetMapping("/all")
    public Iterable<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/by_id/{id}")
    public Optional<Course> getCourseById(@PathVariable(value = "id") long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/by_name/{name}")
    public Iterable<Course> getCourseByName(@PathVariable(value = "name") String name) {
        return courseService.getCourseByName(name);
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable(value = "id") long id, @RequestBody Course course){
        return courseService.updateCoursebyId(id,course);
    }

    @DeleteMapping("{id}")
    public String deleteCoursebyId(@PathVariable(value = "id") long id){
        return courseService.deleteCourseById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllCourses(){
        courseService.deleteAllCourses();
    }
}