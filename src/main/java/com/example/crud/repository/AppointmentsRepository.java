/**
 * 
 */
package com.example.crud.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.crud.entity.Appointment;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Interface que contiene el CRUD con Spring JPA para la tabla appointments
*/
public interface AppointmentsRepository extends CrudRepository<Appointment, Long> {

}
