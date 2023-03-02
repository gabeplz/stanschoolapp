package crudgedoe.crudtest.service;

import crudgedoe.crudtest.dto.SchoolGetDto;
import crudgedoe.crudtest.dto.SchoolPostDto;
import crudgedoe.crudtest.mapper.SchoolMapper;
import crudgedoe.crudtest.models.ContactPerson;
import crudgedoe.crudtest.models.School;
import crudgedoe.crudtest.models.Student;
import crudgedoe.crudtest.repository.SchoolRepository;
import crudgedoe.crudtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    SchoolMapper schoolMapper;

    @Autowired
    StudentRepository studentRepository;
//    public School newSchool(School school) {
//        return schoolRepository.save(school);
//    }
//
//    public Optional<School> getSchoolById(long id) {
//        return schoolRepository.findById(id);
//    }

    public void newSchool(SchoolPostDto school){
        School newSchool = schoolMapper.toEntity(school);
        schoolRepository.save(newSchool);
    }

    public SchoolGetDto getSchoolById(Long id){
        School school = schoolRepository.findById(id).get();
        return schoolMapper.toDto(school);

    }

    public Iterable<School> getAllSchools() {
        return schoolRepository.findAll();
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

    public void addStudentToSchool(Long schoolId, Long studentId) {
        School tempSchool = schoolRepository.findById(schoolId).get();
        Student tempStudent = studentRepository.findById(studentId).get();

        tempSchool.getStudent().add(tempStudent);
        tempStudent.setSchool(tempSchool);
        schoolRepository.save(tempSchool);
    }

}
