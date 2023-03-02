package crudgedoe.crudtest.controller;


import crudgedoe.crudtest.dto.SchoolGetDto;
import crudgedoe.crudtest.dto.SchoolPostDto;
import crudgedoe.crudtest.models.School;
import crudgedoe.crudtest.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

//    @PostMapping("/new")
//    public School newSchool(@RequestBody School school) {
//        return schoolService.newSchool(school);
//    }
//
//    @GetMapping("/by_id/{id}")
//    public Optional<School> getSchoolById(@PathVariable(value = "id") long id) {
//        return schoolService.getSchoolById(id);
//    }

    @PostMapping("/new")
    public void newSchool(@RequestBody SchoolPostDto school){
        schoolService.newSchool(school);
    }

    @GetMapping("/by_id/{id}")
    public SchoolGetDto getSchoolById(@PathVariable(value ="id") Long id){return schoolService.getSchoolById(id);}

//    @GetMapping("/all")
//    public Iterable<School> getAllSchools() {
//        return schoolService.getAllSchools();
//    }
    @GetMapping("/all")
    public Iterable<SchoolGetDto> getAllSchools() {
    return schoolService.getAllSchools();
}


    @GetMapping("/by_name/{name}")
    public Iterable<School> getSchoolByName(@PathVariable(value = "name") String name) {
        return schoolService.getSchoolByName(name);
    }

    @PutMapping("/{id}")
    public School updateSchoolById(@PathVariable(value = "id") long id, @RequestBody School school) {
        return schoolService.updateSchoolById(id, school);
    }

    @PutMapping("/add/{schoolId}/{studentId}")
    public void addStudentToSchool(@PathVariable(value = "schoolId") long schoolId, @PathVariable(value = "studentId") long studentId) {
        schoolService.addStudentToSchool(schoolId, studentId);
    }
    @DeleteMapping("{id}")
    public String deleteSchoolById(@PathVariable(value = "id") long id) {
        return schoolService.deleteSchoolById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllSchools() {
        schoolService.deleteAllSchools();
    }
}
