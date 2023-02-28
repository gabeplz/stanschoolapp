package crudgedoe.crudtest.controller;

import crudgedoe.crudtest.models.ContactPerson;
import crudgedoe.crudtest.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/contactPerson")
public class ContactPersonController {

    @Autowired
    ContactPersonService contactPersonService;

    @PostMapping("/new")
    public ContactPerson newContactPerson(@RequestBody ContactPerson contactPerson) {
        return contactPersonService.newContactPerson(contactPerson);
    }

    @GetMapping("/all")
    public Iterable<ContactPerson> getAllContactPersons() {
        return contactPersonService.getAllContactPersons();
    }

    @GetMapping("/by_id/{id}")
    public Optional<ContactPerson> getPersonById(@PathVariable(value = "id") long id) {
        return contactPersonService.getContactPersonById(id);
    }



    @GetMapping("/by_name/{name}")
    public Iterable<ContactPerson> getContactPersonByName(@PathVariable(value = "name") String name) {
        return contactPersonService.getContactPersonByName(name);
    }

    @PutMapping("/{id}")
    public ContactPerson updateContactPersonById(@PathVariable(value = "id") long id, @RequestBody ContactPerson contactPerson) {
        return contactPersonService.updateContactPersonById(id, contactPerson);
    }

    @DeleteMapping("{id}")
    public String deleteContactPersonById(@PathVariable(value = "id") long id) {
        return contactPersonService.deleteContactPersonById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllContactPersons() {
        contactPersonService.deleteAllCourses();
    }

//    @PutMapping("/add/{contactId}/{studentId}")
//    public String addStudentToCourse(@PathVariable(value = "contactId") long contactId, @PathVariable(value = "studentId") long studentId) {
//        contactPersonService.addStudentToContactPerson(contactId, studentId);
//        return "hello";
//    }

}
