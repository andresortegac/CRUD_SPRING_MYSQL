/**
 * 
 */
package com.example.crud.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Appointment;
import com.example.crud.repository.AppointmentsRepository;
import com.example.crud.service.AppointmentsService;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Clase que implementa los metodos de lógica de negocio de la interface AppointmentsService
*/

@Service
public class AppointmentsServiceImpl implements AppointmentsService {
	
	@Autowired
	private AppointmentsRepository appointmentsRepository;

	@Override
	public List<Appointment> consultarAppointments() {
		List<Appointment> appointmentsDataSourse =StreamSupport.stream(this.appointmentsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return appointmentsDataSourse;
	}

}
