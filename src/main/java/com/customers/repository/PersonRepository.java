package com.customers.repository;

import com.customers.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Clase Repositorio para los métodos de acceso a la base de datos de los clientes personales
 */
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

}
