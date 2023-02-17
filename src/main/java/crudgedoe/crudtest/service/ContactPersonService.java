package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.ContactPerson;
import crudgedoe.crudtest.repository.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ContactPersonService {

    @Autowired
    ContactPersonRepository contactPersonRepository;

    public ContactPerson newContactPerson(ContactPerson contactPerson) {
        return contactPersonRepository.save(contactPerson);
    }

    public Iterable<ContactPerson> getAllContactPersons() {
        return contactPersonRepository.findAll();
    }

    public Optional<ContactPerson> getContactPersonById(long id) {
        return contactPersonRepository.findById(id);
    }

    public Iterable<ContactPerson> getContactPersonByName(String name) {
        return contactPersonRepository.getContactPersonByName(name);
    }

    public ContactPerson updateContactPersonById(long id, ContactPerson contactPerson) {
        if (!contactPersonRepository.existsById(id)) {
            return null;
        }
        ContactPerson oldContactPerson = contactPersonRepository.findById(id).get();

        if (contactPerson.getName() != null) {
            oldContactPerson.setName(contactPerson.getName());
        }

        if (contactPerson.getPhoneNumber() != null) {
            oldContactPerson.setPhoneNumber(contactPerson.getPhoneNumber());
        }

        System.out.println(contactPerson.getName());
        System.out.println(contactPerson.getPhoneNumber());

        return contactPersonRepository.save(oldContactPerson);
    }

    public String deleteContactPersonById(long id) {
        if (contactPersonRepository.existsById(id)) {
            contactPersonRepository.deleteById(id);
            return "deleted successfully";
        }
        return "no person with matching id found";
    }

    public void deleteAllCourses() {
        contactPersonRepository.deleteAll();
    }
}