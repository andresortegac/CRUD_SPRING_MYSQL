/**
 * 
 */
package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.crud.entity.Appointment;
import com.example.crud.entity.Test;

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

	/**
	*Metodo que permite consultar por Id un appointment 
	*@param id {@link Long} objeto appointment a consultar
	*@return appointment consultado por id
	*/
	
	Appointment consultarByIdAppointment(Long id);
	
	/**
	*Metodo que permite guardar un appointment 
	*@param appointment {@link Appointment} objeto appointment a guardar
	*@return appointment guardado
	*/
	
	Appointment guardarAppointment(Appointment appointment);
	
	/**
	*Metodo que permite actualizar un appointment 
	*@param appointment {@link Test} objeto appointment a actualizar
	*@return appointment actualizado
	*/
	
	Appointment actualizarAppointment(Appointment appointment);
	
	/**
	*Metodo que permite eliminar un appointment 
	*@param id {@link Long} objeto appointment a eliminar
	*@return appointment eliminado
	*/
	
	void eliminarAppointment(Long id);
	
	/**
	*Metodo que permite consultar por date un appointment 
	*@param date {@link String} objeto appointment a consultar
	*@return appointment consultado por date
	*/
	
	Appointment consultarByDateAppointment(String date);
	
	/**
	*Metodo que permite consultar por id_affiliate un appointment 
	*@param id_affiliate {@link Affiliate} objeto appointment a consultar
	*@return appointment consultado por id_affiliate
	*/
	
	List<Appointment> getAppointmentsByAffiliate(long id);
}
