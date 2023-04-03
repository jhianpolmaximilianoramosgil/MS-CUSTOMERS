package com.customers.service;

import com.customers.dto.CompanyRequestDto;
import com.customers.dto.CompanyResponseDto;
import com.customers.dto.Message;
import com.customers.model.Company;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase interfaz de servicio para las clientes empresariales
 */
public interface CompanyService {

	Flux<Company> getAll();

	Mono<Company> getCompanyById(String companyId);

	Mono<Company> createCompany(CompanyRequestDto companyRequestDto);

	Mono<Company> updateCompany(CompanyRequestDto companyRequestDto);

	Mono<Message> deleteCompany(String companyId);
	
	Mono<CompanyResponseDto> requestProfilePyme(CompanyRequestDto companyRequestDto);

}
