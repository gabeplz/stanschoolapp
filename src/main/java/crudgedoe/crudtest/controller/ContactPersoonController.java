package crudgedoe.crudtest.controller;

import crudgedoe.crudtest.models.ContactPersoon;
import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.service.ContactPersoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/contactpersoon")
public class ContactPersoonController {

    @Autowired
    ContactPersoonService contactPersoonService;

    @PostMapping("/new")
    public ContactPersoon newContactPersoon(@RequestBody ContactPersoon contactPersoon){
        return contactPersoonService.newContactPersoon(contactPersoon);
    }

    @GetMapping("/all")
    public Iterable<ContactPersoon> getAllContactPersonen(){
        return contactPersoonService.getAllContactPersonen();
    }

    @GetMapping("/by_id/{id}")
    public Optional<ContactPersoon> getCourseById(@PathVariable(value = "id") long id) {
        return contactPersoonService.getContactPersoonById(id);
    }

    @GetMapping("/by_name/{name}")
    public Iterable<ContactPersoon> getContacPersoonByName(@PathVariable(value = "name") String name){
        return contactPersoonService.getContactPersoonByName(name);
    }

    @PutMapping("/{id}")
    public ContactPersoon updateContactPersoonById(@PathVariable(value = "id") long id, @RequestBody ContactPersoon contactPersoon){
        return contactPersoonService.updateContactPersoonbyId(id,contactPersoon);
    }

    @DeleteMapping("{id}")
    public String deleteCoursebyId(@PathVariable(value = "id") long id){
        return contactPersoonService.deleteCourseById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllCourses(){
        contactPersoonService.deleteAllCourses();
    }

}
