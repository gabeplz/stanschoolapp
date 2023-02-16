package crudgedoe.crudtest.repository;

import crudgedoe.crudtest.models.Leerling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface LeerlingRepository extends CrudRepository <Leerling, Long>{


    Iterable<Leerling> getLeerlingByName(String naam);
}
