package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.Leerling;
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

    public Iterable<School> getAllScholen() {
        return  schoolRepository.findAll();
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
        return "die bestaat niet";
    }

    public void deleteAllScholen(){
        schoolRepository.deleteAll();
    }

    public School updateSchoolbyId(long id, School school) {
        if(!schoolRepository.existsById(id)){
            return null;
        }
        School oldSchool = schoolRepository.findById(id).get();

        if (school.getName() != null){
            oldSchool.setName(school.getName());
        }

        if (school.getCity() != null){
            oldSchool.setCity(school.getCity());
        }

        System.out.println(school.getName());
        System.out.println(school.getCity());

        return schoolRepository.save(oldSchool);
    }
}
// TODO: 15/02/2023 vervang alle getters en setters in schoolmodel met regel @Data om te kijken of het werkt
