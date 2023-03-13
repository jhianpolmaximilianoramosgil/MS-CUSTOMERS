package com.ms_customers.service.impl;

import com.ms_customers.model.Customers;
import com.ms_customers.repository.CustomersRepository;
import com.ms_customers.service.CustomersService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.*;



@Slf4j
@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public Flux<Customers> findCustomers() {
        //  Flux<Customers> list = customersRepository.findAll().publishOn(Schedulers.boundedElastic());
        log.info("Mostrando todos los Customers");
        return customersRepository.findAll();
    }

    @Override
    public Mono<Customers> findCustomersById(Long id) {
        log.info("Customer ID = " + id);
        return customersRepository.findById(id);
    }

    @Override
    public Flux<Customers> findByStatus(boolean status) {
        log.info(" Customer Filter = " + status);
        return customersRepository.findByStatus(status);
    }

    @Override
    public Mono<Customers> createCustomers(Customers customers) {
        customers.setStatus(true);
        String type = customers.getType();
        if(type.equals("Personal") || type.equals("Empresarial")) {
            log.info("Creando Customer");
            return customersRepository.save(customers);
        } else {
            log.info("Error Customer Type");
            return null;
        }
    }



    @Override
    public Mono<Customers> updateCustomers(Customers customers) {
        log.info("Actualizando Customer");
        customers.setStatus(true);
        return customersRepository.save(customers);
    }

    @Override
    public Mono<ResponseEntity<Customers>> deleteCustomers(Long id) {
        log.info("Customer eliminada = " + id);
        return customersRepository.findById(id).flatMap(newCustomers -> {
            newCustomers.setStatus(false);
            return customersRepository.save(newCustomers);
        }).map(updatedCustomers -> new ResponseEntity<>(updatedCustomers, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Customers>> restoreCustomers(Long id) {
        log.info("Customer eliminada = " + id);
        return customersRepository.findById(id).flatMap(newCustomers -> {
            newCustomers.setStatus(true);
            return customersRepository.save(newCustomers);
        }).map(updatedCustomers -> new ResponseEntity<>(updatedCustomers, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
    }




}
