package crudgedoe.crudtest.controller;

import crudgedoe.crudtest.models.Student;
import crudgedoe.crudtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService StudentService;

    @PostMapping("/new")
    public Student newStudent(@RequestBody Student student) {
        return StudentService.newStudent(student);
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {
        return StudentService.getAllLeerlingen();
    }

    @GetMapping("/by_id/{id}")
    public Optional<Student> getStudentById(@PathVariable(value = "id") long id) {
        return StudentService.getLeerlingById(id);
    }

    @GetMapping("/by_name/{name}")
    public Iterable<Student> getStudentByName(@PathVariable(value = "name") String name) {
        return StudentService.getStudentByName(name);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return StudentService.updateStudentById(id, student);
    }

    @DeleteMapping("{id}")
    public String deleteStudentById(@PathVariable(value = "id") long id) {
        return StudentService.deleteStudentById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllStudents() {
        StudentService.deleteAlStudents();
    }
}
