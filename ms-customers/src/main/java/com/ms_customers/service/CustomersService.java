package com.ms_customers.service;

import com.ms_customers.model.Customers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.*;

@Service
public interface CustomersService {

    Flux<Customers> findCustomers();

    Mono<Customers> findCustomersById(Long id);

    Flux<Customers> findByStatus(boolean status);

    Mono<Customers> createCustomers(Customers customers);

    Mono<Customers> updateCustomers(Customers customers);

    Mono<ResponseEntity<Customers>> deleteCustomers(Long id);

    Mono<ResponseEntity<Customers>> restoreCustomers(Long id);

}
