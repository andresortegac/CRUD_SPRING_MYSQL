/**
 * 
 */
package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;
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

	@Override
	public Appointment consultarByIdAppointment(Long id) {
		Optional<Appointment> optionalAppointment = appointmentsRepository.findById(id);
		
		if(optionalAppointment.isPresent()) {
			return optionalAppointment.get();
		}else {
			return new Appointment();
		}	
	}

	@Override
	public Appointment guardarAppointment(Appointment appointment) {
		return this.appointmentsRepository.save(appointment);
	}

	@Override
	public Appointment actualizarAppointment(Appointment appointment) {
		return this.appointmentsRepository.save(appointment);
	}

	@Override
	public void eliminarAppointment(Long id) {
		this.appointmentsRepository.deleteById(id);
		
	}

	@Override
	public Appointment consultarByDateAppointment(String date) {		
		Optional<Appointment> optionalAppointment = appointmentsRepository.findByDate(date);
		
		if(optionalAppointment.isPresent()) {
			return optionalAppointment.get();
		}else {
			return new Appointment();
		}	
	}

	@Override
	public List<Appointment> getAppointmentsByAffiliate(long id) {
		return appointmentsRepository.findByAffiliateId(id);
	}

	@Override
	public Optional<Appointment> findById(Long id) {
		return appointmentsRepository.findById(id);
	}

	

	

}
