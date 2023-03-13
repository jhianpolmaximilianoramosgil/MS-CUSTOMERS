package com.ms_customers.controller;

import com.ms_customers.model.Customers;
import com.ms_customers.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;


@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping
    public Flux<Customers> findCustomers() {
        return customersService.findCustomers();
    }

    @GetMapping("/id/{id}")
    public Mono<Customers> findCustomersById(@PathVariable Long id) {
        return customersService.findCustomersById(id);
    }

    @GetMapping("/status/{status}")
    public Flux<Customers> findByStatus(@PathVariable boolean status)
    { return customersService.findByStatus(status); }



    @PostMapping
    public Mono <Customers> createCustomers(@RequestBody Customers customers) {
        return customersService.createCustomers(customers);
    }

    @PutMapping
    public Mono<Customers> updateCustomers(@RequestBody Customers customers) {
        return customersService.updateCustomers(customers);
    }

    @PostMapping("/delete/{id}")
    public Mono<ResponseEntity<Customers>> deleteCustomers(@PathVariable Long id) {
        return customersService.deleteCustomers(id);
    }

    @PostMapping("/restore/{id}")
    public Mono<ResponseEntity<Customers>> restoreCustomers(@PathVariable Long id) {
        return customersService.restoreCustomers(id);
    }

}
