package com.customers.dto;

import com.customers.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase de transferencia de datos para la respuesta
 * de los clientes personales
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDto{
	private Person person;
	private String message;
}
