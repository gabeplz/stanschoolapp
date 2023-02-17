package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.Student;
import crudgedoe.crudtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student newStudent(Student student) {
        return studentRepository.save(student);
    }

    public Iterable<Student> getAllLeerlingen() {
        return  studentRepository.findAll();
    }

    public Optional<Student> getLeerlingById(long id) {
        return studentRepository.findById(id);
    }
    
    public Student updateStudentById(long id, Student student) {
        if(!studentRepository.existsById(id)){
            return null;
        }
        Student oldStudent = studentRepository.findById(id).get();

        if (student.getName() != null){
            oldStudent.setName(student.getName());
        }

        if (student.getGrade() != null){
            oldStudent.setGrade(student.getGrade());
        }

        System.out.println(student.getName());
        System.out.println(student.getGrade());

        return studentRepository.save(oldStudent);
    }
    
    public String deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "goed gedaan";
        }
        return "no student with matching id found";
    }

    public void deleteAlStudents() {
        studentRepository.deleteAll();
    }

    public Iterable<Student> getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }
}
