package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.School;
import crudgedoe.crudtest.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public School newSchool(School school) {
        return schoolRepository.save(school);
    }

    public Iterable<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(long id) {
        return schoolRepository.findById(id);
    }

    public Iterable<School> getSchoolByName(String name) {
        return schoolRepository.getSchoolByName(name);
    }

    public String deleteSchoolById(long id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return "goed gedaan";
        }
        return "no school with matching id found";
    }

    public void deleteAllSchools() {
        schoolRepository.deleteAll();
    }

    public School updateSchoolById(long id, School school) {
        if (!schoolRepository.existsById(id)) {
            return null;
        }
        School oldSchool = schoolRepository.findById(id).get();

        if (school.getName() != null) {
            oldSchool.setName(school.getName());
        }

        if (school.getCity() != null) {
            oldSchool.setCity(school.getCity());
        }

        System.out.println(school.getName());
        System.out.println(school.getCity());

        return schoolRepository.save(oldSchool);
    }
}
