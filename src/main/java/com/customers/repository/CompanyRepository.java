package com.customers.repository;

import com.customers.model.Company;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Clase Repositorio para los métodos de acceso a la base de datos de los clientes empresariales
 */
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

}
