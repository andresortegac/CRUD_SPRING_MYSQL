/**
 * 
 */
package com.example.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping()
	@RequestMapping(value = "guardarAppointment", method = RequestMethod.POST)	
    
	public ResponseEntity<?> guardarAppointment(@RequestBody Appointment appointment){	
		
		Appointment appointmentGuardado = this.appointmentsServiceImpl.guardarAppointment(appointment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentGuardado);
		
	}
	
	@PutMapping()
	@RequestMapping(value = "actualizarAppointment", method = RequestMethod.PUT)	
    
	public ResponseEntity<?> actualizarAppointment(@RequestBody Appointment appointment){	
		
		Appointment appointmentActualizado = this.appointmentsServiceImpl.actualizarAppointment(appointment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentActualizado);
		
	}
	
	@DeleteMapping()
	@RequestMapping(value = "eliminarAppointment/{id}", method = RequestMethod.DELETE)	
    
	public ResponseEntity<?> eliminarAppointment(@PathVariable Long id){	
		
		this.appointmentsServiceImpl.eliminarAppointment(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/consultarByDateAppointment/{date}")
	
	public Appointment consultarByDateAppointment(@PathVariable String date){		
		
		return appointmentsServiceImpl.consultarByDateAppointment(date); 
	}	
	
	
	@GetMapping("/consultarByAffiliateAppointment/{id}")
    public List<Appointment> getAppointmentsByAffiliate(@PathVariable("id") long id) {
        return appointmentsServiceImpl.getAppointmentsByAffiliate(id);
    }
	
	

}
