package com.nttdata.bank.client.repository;

import com.nttdata.bank.client.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, Integer> {

    Flux<Client> findByCodProfile(String codProfile);
}
