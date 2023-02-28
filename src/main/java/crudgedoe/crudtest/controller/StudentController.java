package crudgedoe.crudtest.controller;

import crudgedoe.crudtest.dto.StudentGetDto;
import crudgedoe.crudtest.dto.StudentPostDto;
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
    StudentService studentService;

//    @PostMapping("/new")
//    public Student newStudent(@RequestBody Student student) {
//        return studentService.newStudent(student);
//    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllLeerlingen();
    }

    @PostMapping("/new")
    public void newStudent(@RequestBody StudentPostDto student) {
        studentService.newStudent(student);
    }


    @GetMapping("/by_id/{id}")
    public StudentGetDto getStudentById(@PathVariable(value = "id") Long id) {
        StudentGetDto a = studentService.getStudentById(id);
        return studentService.getStudentById(id);
    }



    @GetMapping("/by_name/{name}")
    public Iterable<Student> getStudentByName(@PathVariable(value = "name") String name) {
        return studentService.getStudentByName(name);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping("{id}")
    public String deleteStudentById(@PathVariable(value = "id") long id) {
        return studentService.deleteStudentById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllStudents() {
        studentService.deleteAlStudents();
    }
}
