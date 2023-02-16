package crudgedoe.crudtest.controller;

import crudgedoe.crudtest.models.Leerling;
import crudgedoe.crudtest.service.LeerlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/leerling")
public class LeerlingController {

    @Autowired
    LeerlingService leerlingService;

    @PostMapping("/new")
    public Leerling newLeerling(@RequestBody Leerling leerling){
        return leerlingService.newLeerling(leerling);
    }

    @GetMapping("/all")
    public Iterable<Leerling> getAllLeerlingen(){
        return leerlingService.getAllLeerlingen();
    }

    @GetMapping("/by_id/{id}")
    public Optional<Leerling> getLeerlingById(@PathVariable(value = "id") long id) {
        return leerlingService.getLeerlingById(id);
    }

    @GetMapping("/by_name/{name}")
    public Iterable<Leerling> getLeerlingByName(@PathVariable(value = "name") String name) {
        return leerlingService.getLeerlingByName(name);
    }

    @PutMapping("/{id}")
    public Leerling updateLeerlingById(@PathVariable(value = "id") long id, @RequestBody Leerling leerling){
        return leerlingService.updateLeerlingbyId(id,leerling);
    }

    @DeleteMapping("{id}")
    public String deleteLeerlingbyId(@PathVariable(value = "id") long id){
        return leerlingService.deleteLeerlingById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllLeerlingen(){
        leerlingService.deleteAllLeerlingen();
    }
}
