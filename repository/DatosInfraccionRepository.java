package com.examplespring.pruebamvc.repository;

import com.examplespring.pruebamvc.model.DatosInfraccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface DatosInfraccionRepository extends MongoRepository<DatosInfraccion, Integer> {
    ArrayList<DatosInfraccion> findByDniInfractor(String dni);
}
