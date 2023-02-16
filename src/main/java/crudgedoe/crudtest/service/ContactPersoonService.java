package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.ContactPersoon;
import crudgedoe.crudtest.models.Course;
import crudgedoe.crudtest.repository.ContactPersoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ContactPersoonService {

    @Autowired
    ContactPersoonRepository contactPersoonRepository;


    public ContactPersoon newContactPersoon(ContactPersoon contactPersoon) {
        return contactPersoonRepository.save(contactPersoon);
    }

    public Iterable<ContactPersoon> getAllContactPersonen() {
        return contactPersoonRepository.findAll();
    }

    public Optional<ContactPersoon> getContactPersoonById(long id) {
        return contactPersoonRepository.findById(id);
    }

    public Iterable<ContactPersoon> getContactPersoonByName(String name) {
        return contactPersoonRepository.getContactPersoonByName(name);
    }

    public ContactPersoon updateContactPersoonbyId(long id, ContactPersoon contactPersoon) {
        if (!contactPersoonRepository.existsById(id)) {
            return null;
        }
        ContactPersoon oldContactPersoon = contactPersoonRepository.findById(id).get();

        if (contactPersoon.getName() != null) {
            oldContactPersoon.setName(contactPersoon.getName());
        }

        if (contactPersoon.getPhoneNumber() != null) {
            oldContactPersoon.setPhoneNumber(contactPersoon.getPhoneNumber());
        }

        System.out.println(contactPersoon.getName());
        System.out.println(contactPersoon.getPhoneNumber());

        return contactPersoonRepository.save(oldContactPersoon);
    }

    public String deleteCourseById(long id) {
        if (contactPersoonRepository.existsById(id)) {
            contactPersoonRepository.deleteById(id);
            return "goed gedaan";
        }
        return "die bestaat niet";
    }


    public void deleteAllCourses() {
        contactPersoonRepository.deleteAll();
    }
}