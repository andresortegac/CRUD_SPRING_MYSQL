/**
 * 
 */
package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entity.Appointment;
import com.example.crud.service.AppointmentsService;

/**
*@author DevOrtega
*@version 1.0 9/01/2023
*Controlador que manipula el flujo de los servicios rest del microservicio de appointment
*/

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
	
	@Autowired
	private AppointmentsService appointmentsServiceImpl;	
	
	@GetMapping
	@RequestMapping(value = "consultarAppointments", method = RequestMethod.GET)	
	
    
	public ResponseEntity<?> consultarAppointments(){
		
		List<Appointment> appointmentsConsultados = this.appointmentsServiceImpl.consultarAppointments();
		
		return ResponseEntity.ok(appointmentsConsultados); 
	}
	
	@GetMapping("/consultarByIdAppointment/{id}")
	
	public Appointment consultarByIdAppointment(@PathVariable Long id){		
		
		return appointmentsServiceImpl.consultarByIdAppointment(id); 
	}

}
