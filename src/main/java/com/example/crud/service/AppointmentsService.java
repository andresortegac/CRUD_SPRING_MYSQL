/**
 * 
 */
package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Appointment;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Interface que contiene los metodos de lógica de negocio para las appointments
*/
public interface AppointmentsService {
	
	/**
	*Metodo que permite consultar un listado de appointments
	*@return listado de appointments
	*/
	
	List<Appointment> consultarAppointments();

}
