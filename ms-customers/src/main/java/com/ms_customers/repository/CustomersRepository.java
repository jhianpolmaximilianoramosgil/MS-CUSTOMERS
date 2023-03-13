package com.ms_customers.repository;

import com.ms_customers.model.Customers;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomersRepository extends ReactiveMongoRepository<Customers,Long> {

    @Query("{'status' : ?0}")
    Flux<Customers> findByStatus(@Param("status") boolean status);

}