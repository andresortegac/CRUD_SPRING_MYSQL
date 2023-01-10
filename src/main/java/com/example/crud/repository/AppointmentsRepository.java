/**
 * 
 */
package com.example.crud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.entity.Appointment;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Interface que contiene el CRUD con Spring JPA para la tabla appointments
*/
public interface AppointmentsRepository extends CrudRepository<Appointment, Long> {
	Optional<Appointment> findByDate(String date);
	
	List<Appointment> findByAffiliateId(long id);

}
