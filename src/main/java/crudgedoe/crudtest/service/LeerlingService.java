package crudgedoe.crudtest.service;

import crudgedoe.crudtest.models.Leerling;
import crudgedoe.crudtest.repository.LeerlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LeerlingService {

    @Autowired
    LeerlingRepository leerlingRepository;

    public Leerling newLeerling(Leerling leerling) {
        return leerlingRepository.save(leerling);
    }

    public Iterable<Leerling> getAllLeerlingen() {
        return  leerlingRepository.findAll();
    }

    public Optional<Leerling> getLeerlingById(long id) {
        return leerlingRepository.findById(id);
    }
    
    public Leerling updateLeerlingbyId(long id, Leerling leerling) {
        if(!leerlingRepository.existsById(id)){
            return null;
        }
        Leerling oldleerling = leerlingRepository.findById(id).get();

        if (leerling.getName() != null){
            oldleerling.setName(leerling.getName());
        }

        if (leerling.getSchoolKlas() != null){
            oldleerling.setSchoolKlas(leerling.getSchoolKlas());
        }

//        if (leerling.getSchool() != null){
//            oldleerling.setSchool(leerling.getSchool());
//        }
        System.out.println(leerling.getName());
//        System.out.println(leerling.getSchool());
        System.out.println(leerling.getSchoolKlas());

        return leerlingRepository.save(oldleerling);
    }
    
    public String deleteLeerlingById(long id) {
        if (leerlingRepository.existsById(id)) {
            leerlingRepository.deleteById(id);
            return "goed gedaan";
        }
        return "die bestaat niet";
    }

    public void deleteAllLeerlingen() {
        leerlingRepository.deleteAll();
    }

    public Iterable<Leerling> getLeerlingByName(String name) {
        return leerlingRepository.getLeerlingByName(name);
    }
}
