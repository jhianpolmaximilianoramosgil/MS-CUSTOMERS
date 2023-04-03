package com.customers.service;

import com.customers.dto.Message;
import com.customers.dto.PersonRequestDto;
import com.customers.dto.PersonResponseDto;
import com.customers.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase interfaz de servicio para las clientes personales
 */
public interface PersonService {

	Flux<Person> getAll();

	Mono<Person> getPersonById(String personId);

	Mono<Person> createPerson(PersonRequestDto personRequestDto);

	Mono<Person> updatePerson(PersonRequestDto personRequestDto);

	Mono<Message> deletePerson(String personId);
	
	Mono<PersonResponseDto> requestProfileVip(PersonRequestDto personRequestDto);

}
